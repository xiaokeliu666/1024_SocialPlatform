package com.rensquare.ai.util;

import org.deeplearning4j.iterator.CnnSentenceDataSetIterator;
import org.deeplearning4j.iterator.LabeledSentenceProvider;
import org.deeplearning4j.iterator.provider.FileLabeledSentenceProvider;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.deeplearning4j.nn.conf.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.ConvolutionMode;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.graph.MergeVertex;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.GlobalPoolingLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CNNUtil {
    public static ComputationGraph createComputationGraph(int cnnLayerFeatureMaps){
        int vectorSize = 300;
        ComputationGraphConfiguration config = new NeuralNetConfiguration.Builder()
                .convolutionMode(ConvolutionMode.Same)
                .graphBuilder()
                .addInputs("input")
                .addLayer("cnn1", new ConvolutionLayer.Builder()
                        .kernelSize(3,vectorSize)
                        .stride(1,vectorSize)
                        .nIn(1)
                        .nOut(cnnLayerFeatureMaps)
                        .build(), "input")
                .addLayer("cnn2", new ConvolutionLayer.Builder()
                        .kernelSize(4,vectorSize)
                        .stride(1,vectorSize)
                        .nIn(1)
                        .nOut(cnnLayerFeatureMaps)
                        .build(), "input")
                .addLayer("cnn3", new ConvolutionLayer.Builder()
                        .kernelSize(5,vectorSize)
                        .stride(1,vectorSize)
                        .nIn(1)
                        .nOut(cnnLayerFeatureMaps)
                        .build(), "input")
                .addVertex("merge", new MergeVertex(), "cnn1", "cnn2",
                        "cnn3")//连接
                .addLayer("globalPool", new GlobalPoolingLayer.Builder()//池化层
                        .build(), "merge")
                .addLayer("out", new OutputLayer.Builder()//输出层
                        .nIn(3*cnnLayerFeatureMaps)
                        .nOut(3)
                        .build(), "globalPool")
                .setOutputs("out")
                .build();
        ComputationGraph net = new ComputationGraph(config);
        net.init();
        return net;
    }

    public static DataSetIterator getDataSetIterator(String path,
                                                     String[] childPaths, WordVectors wordVectors, int minibatchSize,
                                                     int maxSentenceLength,
                                                     Random rng ){
        Map<String,List<File>> reviewFilesMap = new HashMap<>();
        for( String childPath: childPaths){
            reviewFilesMap.put(childPath, Arrays.asList(Objects.requireNonNull(new File(path + "/" + childPath).listFiles())));
        }

        LabeledSentenceProvider sentenceProvider = new
                FileLabeledSentenceProvider(reviewFilesMap, rng);
        return new CnnSentenceDataSetIterator.Builder()
                .sentenceProvider(sentenceProvider)
                .wordVectors(wordVectors)
                .minibatchSize(minibatchSize)
                .maxSentenceLength(maxSentenceLength)
                .useNormalizedWordVectors(false)
                .build();
    }
    public static Map<String, Double> predictions(String vecModel,String cnnModel,String dataPath,String[] childPaths,String content) throws IOException {
        Map<String, Double> map = new HashMap<>();

        ComputationGraph model = ModelSerializer.restoreComputationGraph(cnnModel);
        WordVectors wordVectors = WordVectorSerializer.loadStaticModel(new File(vecModel));
        DataSetIterator dataSet = CNNUtil.getDataSetIterator(dataPath,childPaths, wordVectors, 32, 256, new Random(12345));
        INDArray featuresFirstNegative = ((CnnSentenceDataSetIterator)dataSet).loadSingleSentence(content);
        INDArray predictionsFirstNegative =model.outputSingle(featuresFirstNegative);
        List<String> labels = dataSet.getLabels();
        for (int i = 0; i < labels.size(); i++) {
            map.put(labels.get(i) + "", predictionsFirstNegative.getDouble(i));
        }
        return map;
    }



}

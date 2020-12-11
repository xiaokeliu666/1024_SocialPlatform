package com.rensquare.ai.service;

import com.rensquare.ai.util.CNNUtil;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.*;


import java.io.File;

@Service
public class CNNService {

    @Value("${ai.vecModel}")
    private String vecModel;

    @Value("${ai.cnnModel}")
    private String cnnModel;

    @Value("${ai.dataPath}")
    private String dataPath;

    public boolean build() {
        try {
            ComputationGraph net = CNNUtil.createComputationGraph(100);
            WordVectors wordVectors = WordVectorSerializer.loadStaticModel(new File(vecModel));
            String[] childPaths={"ai","db","web"};
            DataSetIterator trainIter =
                    CNNUtil.getDataSetIterator(dataPath,childPaths, wordVectors, 32, 256,
                            new Random(12345));
            net.fit(trainIter);
            new File(cnnModel).delete();
            ModelSerializer.writeModel(net,cnnModel,true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map textClassify(String content) {
        System.out.println("content:"+content);

        try {
            content=util.IKUtil.split(content," ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] childPaths={"ai","db","web"};
        Map map = null;
        try {
            map = CNNUtil.predictions(vecModel, cnnModel, dataPath, childPaths, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}

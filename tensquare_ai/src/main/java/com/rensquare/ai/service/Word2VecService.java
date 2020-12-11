package com.rensquare.ai.service;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class Word2VecService {

    @Value("${ai.wordLib}")
    private String wordLib;

    @Value("${ai.dataPath}")
    private String dataPath;

    @Value("${ai.vecModel}")
    private String vecModel;


    public void mergeWord() {
        List<String> files = FileUtil.getFiles(dataPath);
        try {
            FileUtil.merge(wordLib,files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    build vec model
    public void build() {
        try {
            SentenceIterator iter = new LineSentenceIterator(new
                    File(wordLib));
            Word2Vec vec = new Word2Vec.Builder()
                    .minWordFrequency(5)
                    .iterations(1)
                    .layerSize(100)
                    .seed(42)
                    .windowSize(5)
                    .iterate(iter)
                    .build();
            vec.fit();
//            delete model before save
            new File(vecModel).delete();
            WordVectorSerializer.writeWordVectors(vec, vecModel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

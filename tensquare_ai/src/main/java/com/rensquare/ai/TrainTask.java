package com.rensquare.ai;

import com.rensquare.ai.service.CNNService;
import com.rensquare.ai.service.Word2VecService;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainTask {
    @Autowired
    private Word2VecService word2VecService;

    @Autowired
    private CNNService cnnService;

    public void trainModel() {
        System.out.println("Start Merging‐‐‐‐‐‐");
        word2VecService.mergeWord();
        System.out.println("Merging Done‐‐‐‐‐‐");
        System.out.println("Start Building‐‐‐‐‐‐");
        word2VecService.build();
        System.out.println("Building Done‐‐‐‐‐‐");
        System.out.println("Start Building Model‐‐‐‐‐‐");
        cnnService.build();
        System.out.println("Building Model Done‐‐‐‐‐‐");
    }
}

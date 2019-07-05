package com.rnehru.dules.context;

import java.util.Map;

public class Page {
    private Map<String, String> questionsAndAnswers;
    public Page(Map<String, String> questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }
}

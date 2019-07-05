package com.rnehru.dules.context;

import java.util.Map;

public class Page {

    private String name;

    private Map<String, String> questionsAndAnswers;

    public Page(String name, Map<String, String> questionsAndAnswers) {
        this.name = name;
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public boolean isComplete() {
        if(null != questionsAndAnswers) {
            return !this.getQuestionsAndAnswers().containsValue(null);
        } else {
            return false;
        }
    }

}

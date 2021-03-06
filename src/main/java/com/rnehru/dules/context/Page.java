package com.rnehru.dules.context;

import java.util.Map;

public class Page {

    private final String name;

    private final Map<String, String> questionsAndAnswers;

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
        return null != questionsAndAnswers &&
                !questionsAndAnswers.isEmpty() &&
                !this.getQuestionsAndAnswers().containsValue(null);
    }

}

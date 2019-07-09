package com.rnehru.dules;


import com.rnehru.dules.api.DuleEvaluator;
import com.rnehru.dules.api.DuleParser;
import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DulesApplication {


    private static final Page p1 = new Page("p", new HashMap<String, String>() {{put("q", "a");}});
    private static final Page p2 = new Page("z", new HashMap<String, String>() {{put("d", "5");}});
    private static final Page p3 = new Page("x", new HashMap<String, String>() {{put("g", "1992-04-02");}});
    private static final List<Page> pages = new ArrayList<Page>(){{add(p1); add(p2); add(p3);}};
    private static final Context context = new Context(pages);
    private static final DuleParser parser = new DuleParser();
    private static final DuleEvaluator evaluator = new DuleEvaluator();


    public static void main(String[] args) {

        print(".question(complete__p)");
        print(".page(p__q__a & complete__p || z__d__>3)");
        print(".page(p__q__a & complete__p || z__d__>3)");
        print(".page(!p__q__d)");
        print(".question(p__q__t)");
        print(".question(x__g__<2010-01-01)");

    }


    private static void print(String dslRule) {
        System.out.println("Rule: [" +
                dslRule +
                "] Produces: [" +
                parser.parseRule(dslRule) +
                "] Evaluates: [" +
                evaluator.evaluate(context, dslRule) +
                "]"
        );
    }
}

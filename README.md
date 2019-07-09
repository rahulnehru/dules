
# Dules

## Overview

Dules a rule evaluation framework used to drive logic on form rendering engines.

It is possible to use the library to add rules for pages and questions.

## Usage

You can use the `api` package's classes to parse and evaluate rules as follows:

```Java
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
        print(".question(p__q__$abc)");
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

```


## Syntax

### Page rule
A page rule is a rule used to drive the visibility of the next page based on the answers that a user may have already provided in their form.

`.page(<rule>)`

### Question rule
A question rule is a rule used to drive the visibility of the next question based on the answers that a user may have already provided in their form.

`.question(<rule>)`

### Examples - Logical rules
Logical rules are thought of as combinators for rules.

**And rules**

`.question(<rule> & <rule>)`

**Not rules**

`.page(!<rule>)`

**Or rules**

`.question(<rule> || <rule>)`

**Combines rules**

`.page(<rule> || <rule> & <rule>)`

### Examples - Contextual rules
Contextual rules are thought of as rules which are dependent on the answers already provided by a user.


**Answer matches** 

`.page(parentpage__parentquestion__answer)`

**Answer in** 

`.page(parentpage__parentquestion__$answer1,answer2,answer3...)`

**Answer less than** 

`.page(parentpage__parentquestion__<4)`


**Answer more than** 

`.page(parentpage__parentquestion__>4)`


**Answer is a date before** 

`.page(parentpage__parentquestion__<2010-01-01)`


**Answer is a date after** 

`.page(parentpage__parentquestion__>2010-01-01)`


**Answer is not null** 

`.page(parentpage__parentquestion)`


**Page exists in context (answer has been attempted)** 

`.page(parentpage)`

**Page is complete** 

`.page(complete__page)`

**Form is complete** 

`.page(complete)`


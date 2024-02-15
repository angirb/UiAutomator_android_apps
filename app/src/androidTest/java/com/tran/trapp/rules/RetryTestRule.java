package com.tran.trapp.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryTestRule implements TestRule {
    private int retryCount; // defining private variable for keeping retry counts

    public RetryTestRule(int retryCount) { // Constructor
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(Statement base, Description description) { // Creating method apply for interface TestRule
        return statement(base, description); // calling method statement and returning it's result
    }

    private Statement statement(final Statement base, final Description description) { // Defining private method statement
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName() + ": run " + (i+1) + "failed");
                    }
                }
                System.err.println(description.getDisplayName() + ": giving up after" + retryCount + "failures");
                throw caughtThrowable;
            }
        };
    }
}

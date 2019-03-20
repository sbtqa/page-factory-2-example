package ru.sbtqa.tag.pagefactory2example.junit;

public class ExampleSteps extends ExampleStepsImpl<ExampleSteps> {

    private static ExampleSteps instance;

    public static ExampleSteps getInstance() {
        if (instance == null) {
            instance = new ExampleSteps();
        }
        return instance;
    }
}

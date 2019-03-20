package ru.sbtqa.tag.pagefactory2example.junit;

import io.qameta.allure.Step;
import ru.sbtqa.tag.pagefactory.html.junit.HtmlStepsImpl;

public class ExampleStepsImpl<T extends ExampleStepsImpl<T>> extends HtmlStepsImpl<T> {

    @Step("Мой тестовый метод \"{parameter}\"")
    public T exampleMethod(String parameter) {
        return (T) this;
    }
}

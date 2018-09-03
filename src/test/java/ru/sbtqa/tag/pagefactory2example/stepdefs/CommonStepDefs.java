package ru.sbtqa.tag.pagefactory2example.stepdefs;

import cucumber.api.java.ru.Допустим;

public class CommonStepDefs {
    // Добавьте сюда необходимые Вам шаги

    @Допустим("^пользователь ждёт$")
    public void пользователь_ждёт() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

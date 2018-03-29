package ru.sbtqa.tag.pagefactory2example.elements.jdi.stepdefs;

import cucumber.api.java.Before;
import ru.sbtqa.tag.pagefactory.JDIUtils;
import ru.sbtqa.tag.pagefactory.PageFactory;

public class StepDefs {
    
    @Before
    public void initJDI() {
        JDIUtils.setJDIConfig(PageFactory::getDriver);
    }
}

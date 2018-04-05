package ru.sbtqa.tag.pagefactory2example.elements.jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import ru.sbtqa.tag.pagefactory.JDIPage;
import ru.sbtqa.tag.pagefactory.JDIUtils;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.context.PageContext;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;

public class AbstractJDIPage extends JDIPage {

    public AbstractJDIPage() {
        JDIUtils.initElementsOnPage(this);
    }

    @ActionTitle("нажимает кнопку")
    public void clickButton(String elementTitle) throws PageException {
        Button element = (Button) JDIUtils.getElementByTitle(PageContext.getCurrentPage(), elementTitle);
        element.click();
    }

    @ActionTitle("заполняет поле")
    public void fillField(String elementTitle, String value) throws PageException {
        Input element = (Input) JDIUtils.getElementByTitle(PageContext.getCurrentPage(), elementTitle);
        element.sendKeys(value);
    }
}

package application.custom;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class Position {

    public static Boolean checkPosition (int x, int y, SelenideElement element) {
        return element.getLocation().getX() == x && element.getLocation().getY() == y;
    }

    public static Boolean checkDistanceFromElement (int x, SelenideElement element) {
        SelenideElement leftSlider = $("aside[data-test='LEFT_SIDER']")
                .$("ul[data-test='MAIN_MENU']");
        return element.getLocation().getX() - leftSlider.getLocation().getX() + leftSlider.getSize().width == x;
    }

}

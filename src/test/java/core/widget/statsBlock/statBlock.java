package core.widget.statsBlock;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

@RequiredArgsConstructor
public class statBlock {
    protected final SelenideElement block;
    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Click on the block to apply the filter
     */
    @Step("Click on the block to apply the filter")
    public void clickOnBlock() {
        block
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Getting text when hovering over a block
     *
     * @return String
     */
    @Step("Getting text when hovering over a block")
    @Attachment
    public String getTextHover() {
        block
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .hover();
        return $("div[class=\"ant-tooltip ant-tooltip-placement-top\"] div[class=\"ant-tooltip-inner\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    /**
     * Getting the value of the "data-icon" attribute. Getting an icon
     *
     * @return String
     */
    @Step("Getting the attribute value \"data-icon\"")
    @Attachment
    public String getIcon() {
        return block.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$("svg")
                .getAttribute("data-icon");
    }

    /**
     * Getting the number from the block corresponding to the number of rows when clicking on the filter
     *
     * @return Integer
     */
    @Step("Getting the number from the block corresponding to the number of rows when clicking on the filter")
    @Attachment
    public int getNumberOfRows() {
        return Integer.parseInt(block.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$("div[class*=\"StatsBlock__itemContent\"] div:nth-child(1)")
                .getText());
    }

    /**
     * Getting the block color in Hex format
     *
     * @return String
     */
    @Step("Getting the block color in Hex format")
    @Attachment
    public String getHexColorBlock() {
        String color = block
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$("div[class*=\"ant-list-item StatsBlock__itemContainer\"]")
                .getAttribute("style");
        Pattern pattern = Pattern.compile("rgb\\((\\d{1,3}, \\d{1,3}, \\d{1,3})\\)");
        Matcher matcher = pattern.matcher(color);

        if (matcher.find()) {
            String rgb = matcher.group(1);
            String NewRGB = rgb.replaceAll(" ", "");
            String[] strings = NewRGB.split("[,\\\\s]+");
            int[] numbers = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                numbers[i] = Integer.parseInt(strings[i]);
            }
            return String.format("#%02X%02X%02X", numbers[0], numbers[1], numbers[2]);
        } else {
            return null;
        }
    }
}

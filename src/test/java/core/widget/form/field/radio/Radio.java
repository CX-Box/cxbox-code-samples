package core.widget.form.field.radio;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Radio extends BaseField<String> {
    public Radio(FormWidget formWidget, String title) {
        super(formWidget, title, "radio");
    }

    public String getValueTag() {
        return "input";
    }

    /**
     * Getting a value from a field
     *
     * @return String
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public String getValue() {
        int size = getContainersActions().size();
        for (int i = 0; i < size; i++) {
            if (getContainersActions().get(i).$(getValueTag()).isSelected()) {
                return getContainersActions().get(i).text();
            }
        }
        return null;
    }

    /**
     * Setting the in the field.
     *
     * @param nameRadio String
     */
    @Override
    @Step("Setting the {nameRadio} in the field")
    public void setValue(String nameRadio) {
        getRadio(nameRadio)
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        getRadio(nameRadio)
                .isSelected();
    }

    /**
     * Getting a value from a field
     *
     * @return HashMap(String, Boolean)
     */
    @Step("Getting a value from a field")
    @Attachment
    public HashMap<String, Boolean> getValues() {
        HashMap<String, Boolean> values = new HashMap<>();
        List<String> list = getContainersActions().texts();
        for (int i = 0; i < list.size(); i++) {
            String text = getContainersActions().get(i).text();
            boolean isSelected = getContainersActions().get(i).$(getValueTag()).isSelected();
            values.put(text, isSelected);
        }
        return values;
    }

    private SelenideElement getRadio(String nameRadio) {
        return getContainersActions().find(Condition.match("check action name: " + nameRadio, b -> b.getText().equals(nameRadio)));
    }

    private ElementsCollection getContainersActions() {
        return getFieldByName()
                .$("div[class=\"ant-form-item-control\"]")
                .$$(By.tagName("label"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}

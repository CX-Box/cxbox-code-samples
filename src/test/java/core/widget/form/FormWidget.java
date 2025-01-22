package core.widget.form;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import core.widget.addfiles.AddFiles;
import core.widget.form.actions.ButtonWithMenu;
import core.widget.form.field.checkbox.CheckBox;
import core.widget.form.field.date.Date;
import core.widget.form.field.datetime.DateTime;
import core.widget.form.field.datetimewithseconds.DateTimeWithSeconds;
import core.widget.form.field.dictionary.Dictionary;
import core.widget.form.field.fileupload.FileUpload;
import core.widget.form.field.hint.Hint;
import core.widget.form.field.input.Input;
import core.widget.form.field.money.Money;
import core.widget.form.field.multifield.MultiField;
import core.widget.form.field.multipleselect.MultipleSelect;
import core.widget.form.field.multivalue.MultiValue;
import core.widget.form.field.multivaluehover.MultiValueHover;
import core.widget.form.field.number.Number;
import core.widget.form.field.number.NumberDigits;
import core.widget.form.field.percent.Percent;
import core.widget.form.field.percent.PercentDigits;
import core.widget.form.field.picklist.InlinePickList;
import core.widget.form.field.picklist.PickList;
import core.widget.form.field.picklist.SuggestionPickList;
import core.widget.form.field.radio.Radio;
import core.widget.form.field.text.Text;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;


@RequiredArgsConstructor
@Getter
@Slf4j
public class FormWidget {

    protected final String title;

    protected final SelenideElement widget;

    protected final CxBoxExpectations waitingForTests = new CxBoxExpectations();


    /**
     * Getting access to field functions Input.
     * The field accepts all text(String) values, depending on the input rules.
     *
     * @param title Field header
     * @return class Input
     */
    @Step("Validation of a field with the Input by heading  {title}")
    public Input input(String title) {
        return new Input(this, title);
    }

    /**
     * Getting access to field functions Money
     * The field accepts numeric values in BigDecimal format.
     *
     * @param title Field header
     * @return class Money
     */
    @Step("Validation of a field with the Money by heading  {title}")
    public Money money(String title) {
        return new Money(this, title);
    }

    /**
     * Getting access to field functions Date
     * The field accepts values in the LocalDate format.
     *
     * @param title Field header
     * @return class Date
     */
    @Step("Validation of a field with the Date by heading  {title}")
    public Date date(String title) {
        return new Date(this, title);
    }

    /**
     * Getting access to field functions DateTime
     * The field accepts values in the LocalDateTime format.
     *
     * @param title Field header
     * @return class DateTime
     */
    @Step("Validation of a field with the DateTime by heading  {title}")
    public DateTime dateTime(String title) {
        return new DateTime(this, title);
    }

    /**
     * Getting access to field functions DateTimeWithSeconds
     * The field accepts values in the LocalDateTime format.
     *
     * @param title Field header
     * @return class DateTimeWithSeconds
     */
    @Step("Validation of a field with the DateTimeWithSeconds by heading  {title}")
    public DateTimeWithSeconds dateTimeWithSeconds(String title) {
        return new DateTimeWithSeconds(this, title);
    }

    /**
     * Getting access to field functions Number
     * The field accepts values in Integer format, only integers.
     *
     * @param title Field header
     * @return class Number
     */
    @Step("Validation of a field with the Number by heading  {title}")
    public Number number(String title) {
        return new Number(this, title);
    }

    /**
     * Getting access to field functions NumberDigits
     * The field accepts values in BigDecimal format, the ability to enter numbers with a fractional part.
     *
     * @param title Field header
     * @return class NumberDigits
     */
    @Step("Validation of a field with the NumberDigits by heading  {title}")
    public NumberDigits numberDigits(String title) {
        return new NumberDigits(this, title);
    }

    /**
     * Getting access to field functions Percent
     * The field accepts values in Integer format, only integers.
     *
     * @param title Field header
     * @return class Percent
     */
    @Step("Validation of a field with the Percent by heading  {title}")
    public Percent percent(String title) {
        return new Percent(this, title);
    }

    /**
     * Getting access to field functions PercentDigits
     * The field accepts values in BigDecimal format, the ability to enter numbers with a fractional part.
     *
     * @param title Field header
     * @return class PercentDigits
     */
    @Step("Validation of a field with the PercentDigits by heading  {title}")
    public PercentDigits percentDigits(String title) {
        return new PercentDigits(this, title);
    }

    /**
     * Getting access to field functions Text
     * The field accepts values in String format
     *
     * @param title Field header
     * @return class Text
     */
    @Step("Validation of a field with the Text by heading  {title}")
    public Text text(String title) {
        return new Text(this, title);
    }

    /**
     * Getting access to field functions Radio
     * The field accepts values in String format, to set them to the true/false state
     *
     * @param title Field header
     * @return class Radio
     */
    @Step("Validation of a field with the Radio by heading  {title}")
    public Radio radio(String title) {
        return new Radio(this, title);
    }

    /**
     * Getting access to field functions CheckBox
     * The field accepts values in the Boolean format.
     *
     * @param title Field header
     * @return class CheckBox
     */
    @Step("Validation of a field with the CheckBox by heading  {title}")
    public CheckBox checkBox(String title) {
        return new CheckBox(this, title);
    }

    /**
     * Getting access to field functions Dictionary
     * The field accepts values in String format
     *
     * @param title Field header
     * @return class Dictionary
     */
    @Step("Validation of a field with the Dictionary by heading  {title}")
    public Dictionary dictionary(String title) {
        return new Dictionary(this, title);
    }

    /**
     * Getting access to field functions MultipleSelect
     * The field accepts values in the Set(String) format to select multiple values.
     *
     * @param title Field header
     * @return class MultipleSelect
     */
    @Step("Validation of a field with the MultipleSelect by heading  {title}")
    public MultipleSelect multipleSelect(String title) {
        return new MultipleSelect(this, title);
    }

    /**
     * Getting access to field functions FileUpload
     * The field accepts values in the File format
     *
     * @param title Field header
     * @return class FileUpload
     */
    @Step("Validation of a field with the FileUpload by heading  {title}")
    public FileUpload fileUpload(String title) {
        return new FileUpload(this, title);
    }

    /**
     * Getting access to field functions MultiValue
     * The field accepts values in the List(String) format to select multiple values.
     *
     * @param title Field header
     * @return class MultiValue
     */
    @Step("Validation of a field with the MultiValue by heading  {title}")
    public MultiValue multiValue(String title) {
        return new MultiValue(this, title);
    }

    /**
     * Getting access to field functions Hint
     * The field does not accept values, ReadOnly
     *
     * @param title Field header
     * @return class Hint
     */
    @Step("Validation of a field with the Hint by heading  {title}")
    public Hint hint(String title) {
        return new Hint(this, title);
    }

    /**
     * Getting access to field functions MultiValueHover
     * The field does not accept values, ReadOnly
     *
     * @param title Field header
     * @return class MultiValueHover
     */
    @Step("Validation of a field with the MultiValueHover by heading  {title}")
    public MultiValueHover multiValueHover(String title) {
        return new MultiValueHover(this, title);
    }

    /**
     * Getting access to field functions MultiField
     * The field does not accept values, ReadOnly
     *
     * @param title Field header
     * @return class MultiField
     */
    @Step("Validation of a field with the MultiField by heading  {title}")
    public MultiField multiField(String title) {
        return new MultiField(this, title);
    }

    /**
     * Getting access to field functions InlinePickList
     * The field accepts values via a drop-down list, in String format
     *
     * @param title Field header
     * @return class InlinePickList
     */
    @Step("Validation of a field with the InlinePickList by heading  {title}")
    public InlinePickList inlinePickList(String title) {
        return new InlinePickList(this, title);
    }

    /**
     * Getting access to field functions PickList
     * The field accepts values via Popup, which is opened separately.
     *
     * @param title Field header
     * @return class PickList
     */
    @Step("Validation of a field with the PickList by heading  {title}")
    public PickList pickList(String title) {
        return new PickList(this, title);
    }

    /**
     * Getting access to field functions SuggestionPickList
     * The field accepts values in String format. The associated fields are filled in automatically according to the field type.
     *
     * @param title Field header
     * @return class SuggestionPickList
     */
    @Step("Validation of a field with the SuggestionPickList by heading  {title}")
    public SuggestionPickList suggestionPickList(String title) {
        return new SuggestionPickList(this, title);
    }

    /**
     * Clicking on the button by its name
     *
     * @param actionName Name button on FormWidget
     */
    @Step("Click on the button {actionName}")
    public void clickButton(String actionName) {
        SelenideElement button = getButton(actionName);
        button
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Displaying a list of all buttons in a widget
     */
    @Step("Getting a list of buttons")
    public List<String> getButtons() {
        return getContainersActions().texts();
    }

    private SelenideElement getButton(String actionName) {
        return getContainersActions()
                .find(Condition.match("check action name: " + actionName, b -> b.getText().equals(actionName)));
    }

    private ElementsCollection getContainersActions() {
        return getContainer()
                .findAll(by("type", "button"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    private SelenideElement getContainer() {
        return widget
                .scrollIntoView("{block: \"center\"}")
                .shouldBe(Condition.enabled);
    }

    /**
     * Bulk file upload..
     *
     * @return class AddFiles
     */
    @Step("Validation of the Mass File upload field")
    public Optional<AddFiles> findAddFiles() {
        if (widget.$("button[data-test-widget-action-item=\"true\"]").$(By.linkText("Add Files")).is(Condition.visible)) {
            return Optional.of(new AddFiles(widget));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Getting the row id when creating via Inline Form
     *
     * @return long
     */
    @Step("Getting the row id when creating via Inline Form")
    @Attachment
    public long getIdInlineForm() {
        if (widget.is(Condition.attribute("data-test-widget-list-row-type"))) {
            long l = Long.parseLong(Objects.requireNonNull(widget.getAttribute("data-test-widget-list-row-id")));
            log.info("Id new row is {}", l);
            return l;
        } else {
            throw new UnsupportedOperationException("It's not InlineForm");
        }
    }

    /**
     * Pressing the button and opening the button menu
     *
     * @return class ButtonWithMenu
     */
    @Step("Pressing the button and opening the button menu")
    public Optional<ButtonWithMenu> openMenuButton() {
        for (SelenideElement button : getContainersActions()) {
            if (Objects.requireNonNull(button.getAttribute("class")).matches("ant-dropdown-trigger")) {
                button.click();
                String cssSelector = "div[class=\"ant-dropdown ant-dropdown-placement-bottomLeft\"]";
                if ($(cssSelector).is(Condition.visible)) {
                    return Optional.of(new ButtonWithMenu($(cssSelector)));
                } else {
                    return Optional.empty();
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Getting a list of fields in a heading and type pair
     *
     * @return HashMap(String, String)
     */
    @Step("Getting a list of fields in a heading and type pair")
    @Attachment
    public HashMap<String, String> getFieldTitleAndType() {
        HashMap<String, String> values = new HashMap<>();
        for (SelenideElement field : widget.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).$$("div[data-test]")) {
            String title = field.attr("data-test-field-title");
            String type = field.attr("data-test-field-type");
            values.put(title, type);
        }
        return values;
    }
}

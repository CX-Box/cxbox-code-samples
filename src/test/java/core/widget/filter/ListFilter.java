package core.widget.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import core.widget.ListHelper;
import core.widget.filter.filter.*;
import core.widget.modal.Popup;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

@RequiredArgsConstructor
@Getter
@Slf4j
public class ListFilter {

    protected final String columnType;

    protected final String columnName;

    protected final ListHelper helper;

    protected final SelenideElement widget;

    protected final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Filtering with the field type Input
     *
     * @return InputFilter
     */
    @Step("Filtering with the field type Input")
    public InputFilter inputFilter() {
        return new InputFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Date
     *
     * @return DateFilter
     */
    @Step("Filtering with the field type Date")
    public DateFilter dateFilter() {
        return new DateFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type DateTime
     *
     * @return DateTimeFilter
     */
    @Step("Filtering with the field type DateTime")
    public DateTimeFilter dateTimeFilter() {
        return new DateTimeFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type DateTimeWithSeconds
     *
     * @return DateTimeWithSecondsFilter
     */
    @Step("Filtering with the field type DateTimeWithSeconds")
    public DateTimeWithSecondsFilter dateTimeWithSecondsFilter() {
        return new DateTimeWithSecondsFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Money
     *
     * @return MoneyFilter
     */
    @Step("Filtering with the field type Money")
    public MoneyFilter moneyFilter() {
        return new MoneyFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Number
     *
     * @return NumberFilter
     */
    @Step("Filtering with the field type Number")
    public NumberFilter numberFilter() {
        return new NumberFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Percent
     *
     * @return PercentFilter
     */
    @Step("Filtering with the field type Percent")
    public PercentFilter percentFilter() {
        return new PercentFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type CheckBox
     *
     * @return CheckboxFilter
     */
    @Step("Filtering with the field type CheckBox")
    public CheckboxFilter checkboxFilter() {
        return new CheckboxFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Radio
     *
     * @return RadioFilter
     */
    @Step("Filtering with the field type Radio")
    public RadioFilter radioFilter() {
        return new RadioFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Dictionary
     *
     * @return DictionaryFilter
     */
    @Step("Filtering with the field type Dictionary")
    public DictionaryFilter dictionaryFilter() {
        return new DictionaryFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type FileUpload
     *
     * @return FileUploadFilter
     */
    @Step("Filtering with the field type FileUpload")
    public FileUploadFilter fileUploadFilter() {
        return new FileUploadFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type InlinePickList
     *
     * @return InlinePickListFilter
     */
    @Step("Filtering with the field type InlinePickList")
    public InlinePickListFilter inlinePickListFilter() {
        return new InlinePickListFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type PickList
     *
     * @return PickListFilter
     */
    @Step("Filtering with the field type PickList")
    @Attachment
    public Optional<Popup> pickListFilter() {
        if ($("div[class=\"ant-popover ant-popover-placement-top\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$("button[class=\"ant-btn ant-btn-icon-only\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .is(Condition.visible)) {

            $("div[class=\"ant-popover ant-popover-placement-top\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .$("button[class=\"ant-btn ant-btn-icon-only\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).click();

            return Optional.of(new Popup());
        } else {
            log.info("Новая фильтрация не поддерживается.");
            return Optional.empty();

        }

    }

    /**
     * Filtering with the field type MultiField
     *
     * @return MultiFieldFilter
     */
    @Step("Filtering with the field type MultiField")
    public MultiFieldFilter multiFieldFilter() {
        return new MultiFieldFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type MultipleSelect
     *
     * @return MultipleSelectFilter
     */
    @Step("Filtering with the field type MultipleSelect")
    public MultipleSelectFilter multipleSelectFilter() {
        return new MultipleSelectFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type multiValue
     *
     * @return MultiValueFilter
     */
    @Step("Filtering with the field type multiValue")
    public MultiValueFilter multiValueFilter() {
        return new MultiValueFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type MultiValueHover
     *
     * @return MultiValueHoverFilter
     */
    @Step("Filtering with the field type MultiValueHover")
    public MultiValueHoverFilter multiValueHoverFilter() {
        return new MultiValueHoverFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Text
     *
     * @return TextFilter
     */
    @Step("Filtering with the field type Text")
    public TextFilter textFilter() {
        return new TextFilter(columnType, columnName, helper);
    }

    /**
     * Filtering with the field type Hint
     *
     * @return HintFilter
     */
    @Step("Filtering with the field type Hint")
    public HintFilter hintFilter() {
        return new HintFilter(columnType, columnName, helper);
    }
}

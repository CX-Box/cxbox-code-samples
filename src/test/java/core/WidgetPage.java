package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import core.widget.WidgetType;
import core.widget.additionalinformation.AdditionalInformationWidget;
import core.widget.form.FormWidget;
import core.widget.groupingHierarchy.GroupingHierarchyWidget;
import core.widget.info.InfoWidget;
import core.widget.list.RowsHelper;
import core.widget.modal.Popup;
import core.widget.modal.ShowMessage;
import core.widget.modal.picklist.FormPopup;
import core.widget.statsBlock.StatsBlockWidget;
import core.widget.stepper.StepsWidget;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

public class WidgetPage {

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Searching for a widget by heading and getting access to the class FormWidget
     *
     * @param title Widget title
     * @return FormWidget
     */
    @Step("Validation FormWidget by heading (Title) {title}")
    public FormWidget findFormWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.FORM, title);
        return new FormWidget(title, widget);
    }

    /**
     * Searching for a widget by name and getting access to the class FormWidget
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return FormWidget
     */
    @Step("Validation FormWidget by name {name}")
    public FormWidget findFormWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.FORM, name);
        String widgetAttributeTitle = widget.getAttribute("data-test-widget-title");
        return new FormWidget(widgetAttributeTitle, widget);
    }

    /**
     * Searching for a widget by heading and getting access to the class RowsHelper
     *
     * @param title Widget title
     * @return RowsHelper
     */
    @Step("Validation ListWidget by heading (Title) {title}")
    public RowsHelper findListWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.LIST, title);
        return new RowsHelper(title, widget);
    }

    /**
     * Searching for a widget by name and getting access to the class RowsHelper
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return RowsHelper
     */
    @Step("Validation ListWidget by name {name}")
    public RowsHelper findListWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.LIST, name);
        String widgetAttributeTitle = widget.getAttribute("data-test-widget-title");
        return new RowsHelper(widgetAttributeTitle, widget);
    }

    /**
     * Searching for a widget by heading and getting access to the class InfoWidget
     *
     * @param title Widget title
     * @return InfoWidget
     */
    @Step("Validation InfoWidget by heading (Title) {title}")
    public InfoWidget findInfoWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.INFO, title);
        return new InfoWidget(title, widget);
    }

    /**
     * Searching for a widget by name and getting access to the class InfoWidget
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return InfoWidget
     */
    @Step("Validation InfoWidget by name {name}")
    public InfoWidget findInfoWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.INFO, name);
        String widgetAttributeTitle = widget.getAttribute("data-test-widget-title");
        return new InfoWidget(widgetAttributeTitle, widget);
    }

    /**
     * Searching for a widget by heading and getting access to the class StatsBlockWidget
     *
     * @param title Widget title
     * @return StatsBlockWidget
     */
    @Step("Validation StatsBlockoWidget by heading (Title) {title}")
    public StatsBlockWidget findStatsBlockWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.STATS_BLOCK, title);
        return new StatsBlockWidget(title, widget);
    }

    /**
     * Searching for a widget by name and getting access to the class StatsBlockWidget
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return StatsBlockWidget
     */
    @Step("Validation StatsBlockWidget by name {name}")
    public StatsBlockWidget findStatsBlockWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.STATS_BLOCK, name);
        String widgetAttributeTitle = widget.getAttribute("data-test-widget-title");
        return new StatsBlockWidget(widgetAttributeTitle, widget);
    }

    /**
     * Searching for a widget by heading and getting access to the class AdditionalInformationWidget
     *
     * @param title Widget title
     * @return AdditionalInformationWidget
     */
    @Step("Validation AdditionalInformationWidget by heading (Title) {title}")
    public AdditionalInformationWidget findAdditionalInformationWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.ADDITIONAL_INFORMATION, title);
        return new AdditionalInformationWidget(title, widget);
    }

    /**
     * Searching for a widget by name and getting access to the class AdditionalInformationWidget
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return AdditionalInformationWidget
     */
    @Step("Validation AdditionalInformationWidget by name {name}")
    public AdditionalInformationWidget findAdditionalInformationWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.ADDITIONAL_INFORMATION, name);
        String widgetAttributeTitle = widget.getAttribute("data-test-widget-title");
        return new AdditionalInformationWidget(widgetAttributeTitle, widget);
    }

    /**
     * Searching for a widget by heading and getting access to the class StepsWidget
     *
     * @param title Widget title
     * @return StepsWidget
     */
    @Step("Validation StepsWidget by heading (Title) {title}")
    public StepsWidget findStepsWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.STEPPER, title);
        return new StepsWidget(widget);
    }

    /**
     * Searching for a widget by name and getting access to the class StepsWidget
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return StepsWidget
     */
    @Step("Validation StepsWidget by name {name}")
    public StepsWidget findStepsWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.STEPPER, name);
        return new StepsWidget(widget);
    }

    /**
     * Searching for a widget by heading and getting access to the class StepsWidget
     *
     * @param title Widget title
     * @return StepsWidget
     */
    @Step("Validation GroupingHierarchyWidget by heading (Title) {title}")
    public GroupingHierarchyWidget findGroupingHierarchyWidgetByTitle(String title) {
        SelenideElement widget = findWidgetByTypesAndTitle(WidgetType.GROUPINGHIERARCHY, title);
        return new GroupingHierarchyWidget(widget, title);
    }

    /**
     * Searching for a widget by name and getting access to the class GroupingHierarchyWidget
     *
     * @param name The unique name of the widget is the value of the data-test-widget-name attribute.
     * @return GroupingHierarchyWidget
     */
    @Step("Validation GroupingHierarchyWidget by name {name}")
    public GroupingHierarchyWidget findGroupingHierarchyWidgetByName(String name) {
        SelenideElement widget = findWidgetByTypesAndName(WidgetType.GROUPINGHIERARCHY, name);
        return new GroupingHierarchyWidget(widget, name);
    }

    /**
     * Initialization of the modal window.
     * Required for data entry.
     *
     * @return Popup class of all modal windows
     */
    @Step("Validation of the modal window")
    @Attachment
    public Optional<Popup> findPopup(String typePopup) {
        SelenideElement elementPopup = $("div[data-test-" + typePopup.toLowerCase() + "-popup=\"true\"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout));
        if (elementPopup.is(Condition.visible)) {
            return Optional.of(new Popup());
        } else {
            return Optional.empty();
        }
    }

    private SelenideElement findWidgetByTypesAndTitle(WidgetType type, String title) {
        return $("div[data-test='WIDGET'][data-test-widget-type='" + type.getName() + "'][data-test-widget-title='" + title
                + "']")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout));
    }

    /**
     * Validation FormPopup
     *
     * @param title Heading
     * @return FormPopup
     */
    @Step("Validation FormPopup by heading  {title}")
    public Optional<FormPopup> findFormPopup(String title) {
        SelenideElement elementPopup = $("div[data-test-widget-type=\"FormPopup\"][data-test-widget-title=\"" + title + "\"")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout));
        if (elementPopup.is(Condition.visible)) {
            return Optional.of(new FormPopup(elementPopup));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Validation PostAction message
     *
     * @return ShowMessage
     */
    @Step("Validation PostAction message")
    public Optional<ShowMessage> findPostAction() {
        String alert = "div[data-show=\"true\"]";
        waitingForTests.getWaitAllElements(alert);
        if ($(alert).is(Condition.visible)) {
            return Optional.of(new ShowMessage($(alert)));
        } else {
            return Optional.empty();
        }
    }

    private SelenideElement findWidgetByTypesAndName(WidgetType type, String name) {
        return $("div[data-test='WIDGET'][data-test-widget-type='" + type.getName() + "'][data-test-widget-name='" + name
                + "']")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout));
    }

}

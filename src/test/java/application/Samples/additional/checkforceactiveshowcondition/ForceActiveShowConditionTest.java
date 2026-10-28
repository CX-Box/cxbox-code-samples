package application.Samples.additional.checkforceactiveshowcondition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.form.PlatformFormWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * CXBOX-1432. Widgets hidden by showCondition, the field of the condition is changed by forceActive of the parent form.
 * Sample: org.demo.documentation.additional.checkforceactiveshowcondition
 */
@DisplayName("ForceActive of the parent and showCondition of the child widgets")
@Epic("Samples")
@Tag("Samples")
public class ForceActiveShowConditionTest extends BaseTestForSamples {

	private static final String SCREEN = "ForceActive radio and child showCondition";

	private static final String ACCOUNTABLE_CRS = "Accountable CRS";

	private static final String CRS_STATUS = "CRS status";

	private static PlatformView view(String name) {
		return PlatformApp.screen(SCREEN).secondLevelView(name);
	}

	private static PlatformFormWidget parentForm(PlatformView view) {
		return view.formByName("MyExample1432Form");
	}

	/**
	 * The parent record as it was loaded: child widgets are hidden
	 */
	private static void restoreParent(PlatformFormWidget form) {
		form.radio(CRS_STATUS).setValue("Active non-financial entity");
		form.radio(ACCOUNTABLE_CRS).setValue("Not accountable");
		form.actions().action("Save").click();
	}

	/**
	 * GET data requests of the bc since {@link BrowserDevTools#clearNetworkLog()}
	 */
	private static long dataRequests(String bcName) {
		var url = Pattern.compile(".*/api/v1/data/.*/" + bcName + "(\\?.*)?$");
		return BrowserDevTools.networkRequests().stream()
				.filter(request -> "GET".equals(request.method()) && url.matcher(request.url()).matches())
				.count();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Child list shown by forceActive radio of the parent has data")
	@Description("The child lists are hidden by showCondition on the first open. The forceActive radio of the parent form changes the showCondition field, the child lists are shown and have data without Save of the parent")
	void childListShownByForceActiveHasData() {
		var view = view("Basic");
		var form = parentForm(view);
		var child = view.listByName("MyExample1433List");
		var grandchild = view.listByName("MyExample1435List");

		child.checkVisible(visible -> assertThat(visible).isFalse());
		grandchild.checkVisible(visible -> assertThat(visible).isFalse());

		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		child.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Cyprus");
		grandchild.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(grandchild.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Latvia");

		restoreParent(form);
		child.checkVisible(visible -> assertThat(visible).isFalse());
	}

	@Test
	@Tag("Positive")
	@DisplayName("1. FormPopup with showCondition: no data request before the popup is opened")
	@Description("The FormPopup has showCondition by the forceActive field of the parent. forceActive makes the condition true, but the popup is closed: its data is not requested")
	void popupDataIsNotFetchedBeforeOpen() {
		var view = view("Popup");
		var form = parentForm(view);

		BrowserDevTools.clearNetworkLog();
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		Selenide.sleep(2000);
		assertThat(dataRequests("myexample1440")).isZero();

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("2. Widget with showCondition by a bc outside of its hierarchy")
	@Description("The child list of the owners list has showCondition by the forceActive field of the parent form of another hierarchy. It is shown with the data of the current owner and follows the cursor of the owners")
	void widgetOfAnotherHierarchy() {
		var view = view("Outside hierarchy");
		var form = parentForm(view);
		var owners = view.listByName("MyExample1447List");
		var child = view.listByName("MyExample1441List");

		// the current owner is the first row of the owners list
		var ownerNames = owners.rows().streamCurrentPage().map(row -> row.input("Country").getValue()).toList();
		assertThat(ownerNames).containsExactlyInAnyOrder("Owner 1", "Owner 2");

		child.checkVisible(visible -> assertThat(visible).isFalse());
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		child.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Child of " + ownerNames.get(0).toLowerCase());

		owners.rows().clickRow(1);
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Child of " + ownerNames.get(1).toLowerCase());

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("3. Tree with showCondition by the forceActive field of the parent")
	@Description("The Tree is hidden on the first open and is shown with its nodes after forceActive of the parent")
	void treeShownByForceActive() {
		var view = view("Tree");
		var form = parentForm(view);
		var tree = view.treeByName("MyExample1442Tree");

		tree.checkVisible(visible -> assertThat(visible).isFalse());
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		tree.checkVisible(visible -> assertThat(visible).isTrue());
		$(byText("Tree root")).shouldBe(visible);

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("3. GroupingHierarchy with showCondition by the forceActive field of the parent")
	@Description("The GroupingHierarchy is hidden on the first open and is shown with its records after forceActive of the parent")
	void groupingHierarchyShownByForceActive() {
		var view = view("Grouping hierarchy");
		var form = parentForm(view);
		var groupingHierarchy = view.groupingHierarchyInlineByName("MyExample1443GH");

		groupingHierarchy.checkVisible(visible -> assertThat(visible).isFalse());
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		groupingHierarchy.checkVisible(visible -> assertThat(visible).isTrue());
		groupingHierarchy.expandAll();
		$(byText("Grouping active")).shouldBe(visible);
		$(byText("Grouping passive")).shouldBe(visible);

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("4. Unsaved changes of a shown child bc are kept")
	@Description("The control persons list is changed and not saved. forceActive of the parent shows other child lists and loads their data, the unsaved value of the control person stays")
	void pendingChangesOfChildAreKept() {
		var view = view("Basic");
		var form = parentForm(view);
		var controlPersons = view.listByName("MyExample1434List");
		var child = view.listByName("MyExample1433List");

		controlPersons.rows().clickRow(0).input("Full name").setValue("Unsaved person");
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Cyprus");
		var controlPerson = controlPersons.rows().clickRow(0);
		assertThat(controlPerson.input("Full name").getValue()).isEqualTo("Unsaved person");

		controlPerson.input("Full name").setValue("Control person");
		controlPerson.burgerAction("Save").click();
		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("5. One forceActive field shows several widgets: one data request for each bc")
	@Description("forceActive shows the child and the grandchild lists: the data of each of them is requested once, the data of the shown control persons list is not requested again")
	void severalWidgetsOneRequestEach() {
		var view = view("Basic");
		var form = parentForm(view);
		var child = view.listByName("MyExample1433List");
		var grandchild = view.listByName("MyExample1435List");

		BrowserDevTools.clearNetworkLog();
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Cyprus");
		assertThat(grandchild.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Latvia");
		Selenide.sleep(1000);
		assertThat(dataRequests("myexample1433")).isEqualTo(1);
		assertThat(dataRequests("myexample1435")).isEqualTo(1);
		assertThat(dataRequests("myexample1434")).isZero();
		assertThat(dataRequests("myexample1432")).isZero();

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("6. Children filtered by the parent field: data by the saved parent until Save")
	@Description("The backend filters the children by the CRS status of the parent. CRS status is changed without Save, forceActive shows the list: the data is by the saved CRS status. After Save of the parent - by the new one")
	void childrenByUnsavedParentField() {
		var view = view("Parent filter");
		var form = parentForm(view);
		var child = view.listByName("MyExample1446List");

		form.radio(CRS_STATUS).setValue("Passive non-financial entity");
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		child.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Active record");

		form.actions().action("Save").click();
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Passive record");

		restoreParent(form);
	}

}

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
import org.assertj.core.api.SoftAssertions;
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
		return view.formByName("myexample1432form");
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
		return getRequests("data", bcName);
	}

	/**
	 * GET row meta requests of the bc since {@link BrowserDevTools#clearNetworkLog()}
	 */
	private static long rowMetaRequests(String bcName) {
		return getRequests("row-meta", bcName);
	}

	private static long getRequests(String api, String bcName) {
		// the row meta url ends with the id of the record
		var url = Pattern.compile(".*/api/v1/" + api + "/.*/" + bcName + "(/[^/?]+)?(\\?.*)?$");
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
		var child = view.listByName("myexample1433list");
		var grandchild = view.listByName("myexample1435list");

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
		var owners = view.listByName("myexample1447list");
		var child = view.listByName("myexample1441list");

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
		var tree = view.treeByName("myexample1442tree");

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
		var groupingHierarchy = view.groupingHierarchyInlineByName("myexample1443gh");

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
		var controlPersons = view.listByName("myexample1434list");
		var child = view.listByName("myexample1433list");

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
		var child = view.listByName("myexample1433list");
		var grandchild = view.listByName("myexample1435list");

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
		var child = view.listByName("myexample1446list");

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

	@Test
	@Tag("Positive")
	@DisplayName("7. Chain of hidden bc: only the top bc is requested, the others are loaded by its cascade")
	@Description("The child, the grandchild and the great-grandchild lists are hidden on the first open, none of them has data and cursor. forceActive shows all of them: the data of the top bc without data is requested, its descendants get the data and the row meta from its cascade once, without row meta requests by an empty parent cursor")
	void hiddenChainLoadedByTopBc() {
		var view = view("Hidden chain");
		var form = parentForm(view);
		var child = view.listByName("myexample1448list");
		var grandchild = view.listByName("myexample1449list");
		var greatGrandchild = view.listByName("myexample1450list");

		child.checkVisible(visible -> assertThat(visible).isFalse());
		greatGrandchild.checkVisible(visible -> assertThat(visible).isFalse());

		BrowserDevTools.clearNetworkLog();
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Hidden child");
		assertThat(grandchild.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Hidden grandchild");
		assertThat(greatGrandchild.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Hidden great-grandchild");
		Selenide.sleep(1000);
		// the view opened from the menu of the screen already has the data of myexample1448 (the first level children of
		// myexample1432 are fetched on the view change regardless of showCondition), then myexample1449 is the top bc without data
		assertThat(dataRequests("myexample1448")).isLessThanOrEqualTo(1);
		assertThat(dataRequests("myexample1449")).isEqualTo(1);
		assertThat(dataRequests("myexample1450")).isEqualTo(1);
		assertThat(rowMetaRequests("myexample1449")).isEqualTo(1);
		assertThat(rowMetaRequests("myexample1450")).isEqualTo(1);

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("8. Parent bc without widget on the view")
	@Description("The list with showCondition is the child of a bc that has no widget on the view. forceActive shows the list with the data of the current record of that bc")
	void parentBcWithoutWidget() {
		var view = view("Parent without widget");
		var form = parentForm(view);
		var child = view.listByName("myexample1452list");

		child.checkVisible(visible -> assertThat(visible).isFalse());
		form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
		child.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Child of no widget parent");

		restoreParent(form);
	}

	@Test
	@Tag("Positive")
	@DisplayName("9. Parent list without records")
	@Description("The parent list is shown and has no records, its child list with showCondition has no parent cursor. forceActive shows the empty child list, the data of the child is not requested, the loaded empty parent list is not requested again. The same after the child list is hidden and shown again")
	void emptyParentList() {
		var view = view("Empty parent");
		var form = parentForm(view);
		var child = view.listByName("myexample1454list");
		var softly = new SoftAssertions();

		child.checkVisible(visible -> assertThat(visible).isFalse());
		for (var attempt = 1; attempt <= 2; attempt++) {
			BrowserDevTools.clearNetworkLog();
			form.radio(ACCOUNTABLE_CRS).setValue("Accountable");
			child.checkVisible(visible -> assertThat(visible).isTrue());
			Selenide.sleep(1000);
			assertThat(child.rows().streamCurrentPage()).isEmpty();
			softly.assertThat(dataRequests("myexample1454")).as("data of myexample1454, attempt %s", attempt).isZero();
			softly.assertThat(rowMetaRequests("myexample1454")).as("row meta of myexample1454, attempt %s", attempt).isZero();
			softly.assertThat(dataRequests("myexample1453")).as("data of myexample1453, attempt %s", attempt).isZero();
			softly.assertThat(rowMetaRequests("myexample1453")).as("row meta of myexample1453, attempt %s", attempt).isZero();

			form.radio(ACCOUNTABLE_CRS).setValue("Not accountable");
			child.checkVisible(visible -> assertThat(visible).isFalse());
		}

		restoreParent(form);
		softly.assertAll();
	}

}

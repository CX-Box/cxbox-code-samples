package core.element.widget.field.type.multivalueTree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.expectation.ExpectationPattern;

import static com.codeborne.selenide.Selenide.$;

/**
 * antd confirm dialog shown by options.tree.confirms (paginationUnselect / paginationSelect).
 */
public class TreeConfirm {

	private final ExpectationPattern expectations;

	public TreeConfirm(ExpectationPattern expectations) {
		this.expectations = expectations;
	}

	public SelenideElement element() {
		return $("div.ant-modal-confirm");
	}

	public boolean isShown() {
		return element().is(Condition.visible);
	}

	public String title() {
		return element().shouldBe(Condition.visible, expectations.getTimeout())
				.$(".ant-modal-confirm-title").getText();
	}

	public void ok() {
		element().$$(".ant-modal-confirm-btns button").findBy(Condition.cssClass("ant-btn-primary")).click();
		element().shouldNot(Condition.visible, expectations.getTimeout());
	}

	public void cancel() {
		element().$$(".ant-modal-confirm-btns button").findBy(Condition.not(Condition.cssClass("ant-btn-primary"))).click();
		element().shouldNot(Condition.visible, expectations.getTimeout());
	}

}

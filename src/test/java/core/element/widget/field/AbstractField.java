package core.element.widget.field;

import com.codeborne.selenide.Condition;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;

public interface AbstractField<
		T extends ExpectationPattern,
		S extends AbstractWidget<T, S>,
		V,
		SELF extends AbstractField<T, S, V, SELF>> extends SingleElement {

	S widget();

	@Deprecated
	FieldType fieldType();

	V getValue();

	SELF setValue(V value);

	String valueTag();

	default boolean exist() {
		return element().shouldBe(Condition.exist, widget().getExpectations().getTimeout()).exists();
	}

	default SELF checkExist(Consumer<Boolean> exist) {
		exist.accept(exist());
		return (SELF) this;
	}

	private boolean visible() {
		if (!exist()) {
			throw new IllegalStateException("Cannot check visibility of non-existent field");
		}
		return element().shouldBe(Condition.visible, widget().getExpectations().getTimeout()).exists();
	}


	default SELF checkVisible(Consumer<Boolean> visible) {
		visible.accept(visible());
		return (SELF) this;
	}


}
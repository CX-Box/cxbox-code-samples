package core.element.screen.view;

import core.common.IterableElement;

import java.util.function.Supplier;

public abstract class AbstractView<T extends AbstractView<T>> implements IterableElement {

	public T view(Supplier<T> view) {
		return view.get();
	}

}

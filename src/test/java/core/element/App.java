package core.element;

import core.element.screen.AbstractScreen;

public abstract class App<F extends AbstractScreen> {
	abstract F screen();
}

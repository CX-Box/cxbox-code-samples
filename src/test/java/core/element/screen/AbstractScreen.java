package core.element.screen;

import core.expectation.ExpectationPattern;
import lombok.Getter;


@Getter
public abstract class AbstractScreen extends AwaitContainer {
	private final ExpectationPattern pattern;

	public AbstractScreen(ExpectationPattern pattern) {
		super();
		this.pattern = pattern;
	}
}

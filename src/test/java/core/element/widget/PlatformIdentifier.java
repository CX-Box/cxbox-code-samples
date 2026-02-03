package core.element.widget;

import core.common.Identifier;

public enum PlatformIdentifier implements Identifier {

	NAME("name"),

	TITLE("title"),
	NONE("none");

	private final String typeIdentifier;

	PlatformIdentifier(String typeIdentifier) {
		this.typeIdentifier = typeIdentifier;
	}

	@Override
	public String getTypeIdentifier() {
		return typeIdentifier;
	}

	@Override
	public String getName() {
		return this.name();
	}

}

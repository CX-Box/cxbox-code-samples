package org.demo.documentation.other.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.cxbox.core.service.action.ActionIconSpecifier;


@Getter
@AllArgsConstructor
public enum MyExample6110ActionIconSpecifier  implements ActionIconSpecifier {
	BRANCH("branches")	,
	APP_STORE("appstore")	,
	TEXT("file-text"),
	EDIT("edit"),
	DELETE("delete"),
	MAIL("mail"),
	PLAY_CIRCLE("play-circle"),
	;

	@Override
	public String getActionIconCode() {
		return actionIconCode;
	}

	String actionIconCode;
}

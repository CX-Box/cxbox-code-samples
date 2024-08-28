package org.demo.conf.cxbox.customization.icon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.cxbox.core.service.action.ActionIconSpecifier;

@Getter
@AllArgsConstructor
public enum ActionIcon implements ActionIconSpecifier {
	MENU("menu");

	String actionIconCode;
}

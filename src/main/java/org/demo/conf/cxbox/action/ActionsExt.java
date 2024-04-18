package org.demo.conf.cxbox.action;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.cxbox.core.dto.rowmeta.PreAction;


@UtilityClass
public class ActionsExt {

    public static PreAction confirmWithCustomWidget(@NonNull String message, @NonNull String widget, @NonNull String yesButton, @NonNull String noButton) {
        Map<String, String> customParameters = new HashMap<>();
        customParameters.put("subtype", "confirmWithCustomWidget");

        customParameters.put("widget", widget);

        customParameters.put("yesText", yesButton);

        customParameters.put("noText", noButton);

        return PreAction.custom(message, customParameters);
    }

}

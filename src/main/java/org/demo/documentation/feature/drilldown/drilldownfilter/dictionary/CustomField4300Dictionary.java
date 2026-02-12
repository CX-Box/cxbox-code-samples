package org.demo.documentation.feature.drilldown.drilldownfilter.dictionary;

import org.cxbox.dictionary.Dictionary;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public record CustomField4300Dictionary(String key) implements Dictionary {

	public static final CustomField4300Dictionary CUSTOM_FIELD4300_DICTIONARY1 = new CustomField4300Dictionary("CUSTOM_FIELD4300_DICTIONARY1");

	public static final CustomField4300Dictionary CUSTOM_FIELD4300_DICTIONARY2 = new CustomField4300Dictionary("CUSTOM_FIELD4300_DICTIONARY2");

	public static final CustomField4300Dictionary CUSTOM_FIELD4300_DICTIONARY3 = new CustomField4300Dictionary("CUSTOM_FIELD4300_DICTIONARY3");

	public static final CustomField4300Dictionary CUSTOM_FIELD4300_DICTIONARY4 = new CustomField4300Dictionary("CUSTOM_FIELD4300_DICTIONARY4");

	public static final CustomField4300Dictionary CUSTOM_FIELD4300_DICTIONARY5 = new CustomField4300Dictionary("CUSTOM_FIELD4300_DICTIONARY5");

	public static List<CustomField4300Dictionary> getAllStaticValues() {
		List<CustomField4300Dictionary> values = new ArrayList<>();
		Field[] fields = CustomField4300Dictionary.class.getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(CustomField4300Dictionary.class)) {
				try {
					values.add((CustomField4300Dictionary) field.get(null));
				} catch (IllegalAccessException e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return values;
	}

}

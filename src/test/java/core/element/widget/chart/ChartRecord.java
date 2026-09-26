package core.element.widget.chart;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** A record of a chart with the fields and the chart options of the widget, as the chart component has them. */
record ChartRecord(String id, Map<String, String> values, List<Map<String, Object>> fields, Map<String, Object> options) {

	/** The key of the field with the title, or empty when the widget has no such field. */
	Optional<String> keyByTitle(String title) {
		return fields.stream()
				.filter(field -> Objects.equals(field.get("title"), title))
				.map(field -> (String) field.get("key"))
				.findFirst();
	}

	List<Object> titles() {
		return fields.stream().map(field -> field.get("title")).filter(Objects::nonNull).toList();
	}

	Optional<Map<String, Object>> field(String key) {
		return fields.stream().filter(field -> Objects.equals(field.get("key"), key)).findFirst();
	}

	/** The value of the record by the key, an empty string when the record has no value. */
	String value(String key) {
		return values.getOrDefault(key, "");
	}

	/** The string option of the chart, e.g. {@code valueFieldKey}, or empty when it is not set. */
	Optional<String> option(String name) {
		return Optional.ofNullable(options.get(name)).map(Object::toString);
	}

	/** The option with a list of keys, e.g. {@code descriptionFieldKey}; an empty list when it is not set. */
	@SuppressWarnings("unchecked")
	List<String> listOption(String name) {
		Object value = options.get(name);
		return value instanceof List<?> list ? (List<String>) list : List.of();
	}

}

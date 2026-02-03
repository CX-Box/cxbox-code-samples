package core.element.widget.field;

/**
 * Terminate element
 * Use if you want end fluent chain and not needed anymore checks
 *
 * @param <T> return value on element
 */
public interface Value<T> {
	T value();
}

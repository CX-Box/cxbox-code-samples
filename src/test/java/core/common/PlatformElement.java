package core.common;

import org.openqa.selenium.StaleElementReferenceException;


/**
 * Abstraction of Selenide element
 *
 * @param <T>
 * @param <SELF>
 * @see SingleElement
 * @see IterableElement
 */
public interface PlatformElement<T, SELF extends PlatformElement<T, SELF>> {

	@SuppressWarnings("unchecked")
	default SELF self() {
		return (SELF) this;
	}


	T element() throws StaleElementReferenceException;

}

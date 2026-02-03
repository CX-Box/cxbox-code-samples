package core.common.highlight;

import com.codeborne.selenide.HighlightOptions;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@Slf4j
public final class HighlightManager {

	private static volatile HighlightManager instance;
	private final AtomicReference<HighlightContainer> currentHighlight;
	private HighlightOptions defaultOptions;

	private HighlightManager() {
		this.currentHighlight = new AtomicReference<>();
		this.defaultOptions = HighlightOptions.border("1px solid orange");
	}

	public static HighlightManager getInstance() {
		if (instance == null) {
			synchronized (HighlightManager.class) {
				if (instance == null) {
					instance = new HighlightManager();
				}
			}
		}
		return instance;
	}


	public void highlight(SelenideElement element) {
		highlight(element, defaultOptions);
	}

	public void highlight(SelenideElement element, HighlightOptions options) {
		if (element == null || !element.exists()) return;
		SelenideElement previous = Optional.ofNullable(currentHighlight).map(AtomicReference::get).map(r -> r.element).orElse(null);
		boolean isSameElement = previous != null &&
				previous.getSearchCriteria().equals(element.getSearchCriteria());
		if (!isSameElement) {
			if (previous != null && previous.isDisplayed()) {
				if (currentHighlight.get().style != null) {
					executeJavaScript(
							"arguments[0].setAttribute('style', arguments[1]);",
							currentHighlight.get().element, currentHighlight.get().style
					);
				}
			}
			currentHighlight.set(new HighlightContainer(element, element.getAttribute("style")));
			element.highlight(options);
			element.scrollTo();
		}
	}


	private record HighlightContainer(SelenideElement element, String style) {
	}

	;
}

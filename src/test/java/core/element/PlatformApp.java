package core.element;

import com.codeborne.selenide.WebDriverRunner;
import core.element.screen.PlatformScreen;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class PlatformApp {

	public static PlatformScreen screen(String name) {
		return new PlatformScreen(name);
	}

	public static PlatformScreen currentScreen() {
		return new PlatformScreen();
	}

	/**
	 * The address of the current page ({@code …/#/screen/<screen>/view/<view>}): the links to the samples in the
	 * documentation lead there.
	 */
	public static String getUrl() {
		return Allure.step("Getting the url", step -> {
			logTime(step);
			return WebDriverRunner.url();
		});
	}

}

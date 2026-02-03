package core.element;

import core.element.screen.PlatformScreen;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlatformApp {

	public static PlatformScreen screen(String name) {
		return new PlatformScreen(name);
	}

	public static PlatformScreen currentScreen() {
		return new PlatformScreen();
	}

}

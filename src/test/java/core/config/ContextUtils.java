package core.config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static core.element.PlatformApp.config;

public class ContextUtils {

	/** The content of the application, by the selectors of the project */
	public static SelenideElement mainContext() {
		return $(config().selectors.appLayout).$(config().selectors.appContent);
	}

	/** @deprecated the selectors of the box only: use {@link #mainContext()}, it takes the selectors of the project */
	@Deprecated
	public static final SelenideElement MAIN_CONTEXT = $("section[class*='appLayout']")
			.$("main[class*='ant-layout-content']");

	public static final SelenideElement LEFT_SIDER = $("aside[data-test='LEFT_SIDER']");

	public static final SelenideElement MODAL_WINDOW = $$("div[class^='ant-modal-mask']")
			.filter(Condition.not(Condition.hidden)).first()
			.$(By.xpath(".."))
			.$(By.cssSelector("div[class='ant-modal-content']"));
}

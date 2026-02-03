package core.common.highlight;

import com.codeborne.selenide.commands.*;

public class SelenideHighlightSetup {

	public static void registerAllHighlightedCommands() {
		Commands commands = Commands.getInstance();

		// Click actions
		commands.add("click", new HighlightedCommand<>(new Click()));
		commands.add("doubleClick", new HighlightedCommand<>(new DoubleClick()));
		commands.add("contextClick", new HighlightedCommand<>(new ContextClick()));
		commands.add("hover", new HighlightedCommand<>(new Hover()));

		// Input actions
		commands.add("setValue", new HighlightedCommand<>(new SetValue()));
		commands.add("val", new HighlightedCommand<>(new Val()));
		commands.add("type", new HighlightedCommand<>(new Type()));
		commands.add("append", new HighlightedCommand<>(new Append()));
		commands.add("paste", new HighlightedCommand<>(new Paste()));
		commands.add("clear", new HighlightedCommand<>(new Clear()));

		// Keyboard actions
		commands.add("pressEnter", new HighlightedCommand<>(new PressEnter()));
		commands.add("pressTab", new HighlightedCommand<>(new PressTab()));
		commands.add("pressEscape", new HighlightedCommand<>(new PressEscape()));
		commands.add("press", new HighlightedCommand<>(new Press()));

		// Selection actions
		commands.add("selectOption", new HighlightedCommand<>(new SelectOptionByTextOrIndex()));
		commands.add("selectOptionByValue", new HighlightedCommand<>(new SelectOptionByValue()));
		commands.add("selectOptionContainingText", new HighlightedCommand<>(new SelectOptionContainingText()));
		commands.add("selectRadio", new HighlightedCommand<>(new SelectRadio()));
		commands.add("setSelected", new HighlightedCommand<>(new SetSelected()));

		// Advanced actions
		commands.add("dragAndDrop", new HighlightedCommand<>(new DragAndDrop()));
		commands.add("uploadFile", new HighlightedCommand<>(new UploadFile()));
		commands.add("uploadFromClasspath", new HighlightedCommand<>(new UploadFileFromClasspath()));
		commands.add("download", new HighlightedCommand<>(new DownloadFile()));

		// Scroll actions
		commands.add("scrollTo", new HighlightedCommand<>(new ScrollTo()));
		commands.add("scrollIntoView", new HighlightedCommand<>(new ScrollIntoView()));
		commands.add("scrollIntoCenter", new HighlightedCommand<>(new ScrollIntoCenter()));
		commands.add("scroll", new HighlightedCommand<>(new Scroll()));

		// Other actions
		commands.add("unfocus", new HighlightedCommand<>(new Unfocus()));
	}
}

package org.demo.documentation.other.widgetEditStyles.colortitle.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum WidgetStylesTestEnum {
	TEST1("Test1"),
	TEST2("Test2"),
	TEST3("Test3"),
	TEST4("Test4"),
	TEST5("Test5"),
	TEST6("Test6"),
	TEST7("Test7"),
	TEST8("Test8"),
	TEST9("Test9"),
	TEST10("Test10"),
	TEST11("Test11"),
	TEST12("Test12"),
	TEST13("Test13"),
	TEST14("Test14"),
	TEST15("Test15"),
	TEST16("Test16"),
	TEST17("Test17"),
	TEST18("Test18"),
	TEST19("Test19"),
	TEST20("Test20"),
	TEST21("Test21"),
	TEST22("Test22"),
	TEST23("Test23"),
	TEST24("Test24"),
	TEST25("Test25"),
	TEST26("Test26"),
	TEST27("Test27"),
	TEST28("Test28"),
	TEST29("Test29"),
	TEST30("Test30");

	@JsonValue
	private final String value;

	public static WidgetStylesTestEnum getByValue(@NonNull String value) {
		return Arrays.stream(WidgetStylesTestEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}

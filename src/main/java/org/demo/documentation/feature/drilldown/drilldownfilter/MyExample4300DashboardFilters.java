package org.demo.documentation.feature.drilldown.drilldownfilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.service.drilldown.PlatformDrilldownService;
import org.cxbox.core.service.drilldown.filter.FB;
import org.cxbox.core.service.drilldown.filter.FC;
import org.cxbox.core.service.drilldown.filter.PlatformDrilldownFilterService;
import org.demo.documentation.feature.drilldown.drilldownfilter.dictionary.CustomField4300Dictionary;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;


/**
 * The form and StatsBlock use the same filters for the same target DTO.
 */
public final class MyExample4300DashboardFilters {

	public static final String VIEW = "/screen/MyExample4300/view/MyExample4300PostAction";


	private MyExample4300DashboardFilters() {
	}

	public static boolean isEmpty(MyExample4300PostActionWithCustomBuilderDTO dto) {
		return Stream.of(
						dto.getDictionaryValues(), dto.getDictionaryEnumValues(), dto.getRadioValues(), dto.getDictionaryValue(),
						dto.getCustomFieldMultifield(), (dto.isRangeFilters() ? dto.getCustomFieldNumberTo() : null), (dto.isRangeFilters() ? dto.getCustomFieldMoneyTo() : null), (dto.isRangeFilters() ? dto.getCustomFieldPercentTo() : null),
						(dto.isRangeFilters() ? dto.getCustomFieldDateTo() : null), (dto.isRangeFilters() ? dto.getCustomFieldDateTimeTo() : null), (dto.isRangeFilters() ? dto.getCustomFieldDateTimeWithSecondsTo() : null),
						dto.getCustomFieldMultivalue(),
						dto.getCustomFieldMultipleSelect(),
						dto.getCustomFieldInlinePickList(),
						dto.getCustomFieldPickList(),
						dto.getCustomFieldRadio(),
						dto.getCustomFieldMoney(),
						dto.getCustomFieldPercent(),
						dto.getCustomFieldNumber(),
						dto.getCustomFieldFileUpload(),
						dto.getCustomFieldDictionary(),
						dto.getCustomFieldDateTimeWithSeconds(),
						dto.getCustomFieldDate(),
						dto.getCustomFieldCheckbox(),
						dto.getCustomFieldDateTime(),
						dto.getCustomFieldText(),
						dto.getCustomFieldHint(),
						dto.getCustomFieldMultivalueHover(),
						dto.getCustomFieldHidden(),
						dto.getCustomField())
				.allMatch(value -> value == null || value instanceof MultivalueField field
						&& field.getValues().isEmpty() || "".equals(value));
	}

	/**
	 * Convert the same generated filter URL into query parameters for row-meta reads without URL filters.
	 */
	@SneakyThrows
	public static QueryParameters parameters(MyExample4300PostActionWithCustomBuilderDTO dto) {
		if (isEmpty(dto)) {
			return QueryParameters.emptyQueryParameters();
		}
		var fc = new FC().add(
				CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb -> apply(fb, dto));
		String query = new PlatformDrilldownService(
				new PlatformDrilldownFilterService()).formUrlFilterPart(fc);
		Map<String, String> byBc = new ObjectMapper().readValue(
				URLDecoder.decode(query.substring("filters=".length()), StandardCharsets.UTF_8),
				new TypeReference<>() {
				});
		Map<String, String> values = new HashMap<>();
		for (String pair : byBc.get("myExample4300DrillDown").split("&")) {
			int equals = pair.indexOf('=');
			values.put(URLDecoder.decode(pair.substring(0, equals), StandardCharsets.UTF_8),
					URLDecoder.decode(pair.substring(equals + 1), StandardCharsets.UTF_8));
		}
		return new QueryParameters(values);
	}

	public static void apply(FB<MyExample4300WithDrilldownDTO, ?> fb, MyExample4300PostActionWithCustomBuilderDTO dto) {
		fb
				.multiValue(MyExample4300WithDrilldownDTO_.customFieldMultivalue, dto.getCustomFieldMultivalue())
				.multipleSelect(MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, dto.getCustomFieldMultipleSelect())
				.inlinePickList(MyExample4300WithDrilldownDTO_.customFieldInlinePickList, dto.getCustomFieldInlinePickList())
				.pickList(MyExample4300WithDrilldownDTO_.customFieldPickList, dto.getCustomFieldPickList())
				.radio(
						MyExample4300WithDrilldownDTO_.customFieldRadio,
						dto.getRadioValues() != null && !dto.getRadioValues().getValues().isEmpty()
								? dto.getRadioValues().getValues().stream().map(value -> CustomField4300RadioEnum.getByValue(value.getValue())).toList()
								: Optional.ofNullable(dto.getCustomFieldRadio()).map(List::of).orElse(List.of())
				)

				.fileUpload(MyExample4300WithDrilldownDTO_.customFieldFileUpload, dto.getCustomFieldFileUpload())
				.dictionaryEnum(MyExample4300WithDrilldownDTO_.customFieldDictionary,
						dto.getDictionaryEnumValues() != null && !dto.getDictionaryEnumValues().getValues().isEmpty()
								? dto.getDictionaryEnumValues().getValues().stream().map(value -> CustomField4300DictionaryEnum.getByValue(value.getValue())).toList()
								: Optional.ofNullable(dto.getCustomFieldDictionary()).map(List::of).orElse(List.of()))
				.dictionary(MyExample4300WithDrilldownDTO_.customField4300Dictionary,
						dto.getDictionaryValues() != null && !dto.getDictionaryValues().getValues().isEmpty()
								? dto.getDictionaryValues().getValues().stream().map(value -> new CustomField4300Dictionary(value.getId())).toList()
								: Optional.ofNullable(dto.getDictionaryValue()).map(List::of).orElse(List.of()))
				.checkbox(MyExample4300WithDrilldownDTO_.customFieldCheckbox, dto.getCustomFieldCheckbox())
				.text(MyExample4300WithDrilldownDTO_.customFieldText, dto.getCustomFieldText())
				.multifield(MyExample4300WithDrilldownDTO_.customFieldMultifield, dto.getCustomFieldMultifield())
				.input(MyExample4300WithDrilldownDTO_.customField, dto.getCustomField())
				.hint(MyExample4300WithDrilldownDTO_.customFieldHint, dto.getCustomFieldHint())
				.multivalueHover(MyExample4300WithDrilldownDTO_.customFieldMultivalueHover, dto.getCustomFieldMultivalueHover())
				.suggestionPickList(MyExample4300WithDrilldownDTO_.customFieldHidden, dto.getCustomFieldHidden());
		if (dto.isRangeFilters()) {
			fb.numberFromTo(MyExample4300WithDrilldownDTO_.customFieldNumber, dto.getCustomFieldNumber(), dto.getCustomFieldNumberTo())
					.moneyFromTo(MyExample4300WithDrilldownDTO_.customFieldMoney, dto.getCustomFieldMoney(), dto.getCustomFieldMoneyTo())
					.percentFromTo(MyExample4300WithDrilldownDTO_.customFieldPercent, dto.getCustomFieldPercent(), dto.getCustomFieldPercentTo())
					.dateFromTo(MyExample4300WithDrilldownDTO_.customFieldDate, day(dto.getCustomFieldDate()), day(dto.getCustomFieldDateTo()))
					.dateTimeFromTo(MyExample4300WithDrilldownDTO_.customFieldDateTime, dto.getCustomFieldDateTime(), dto.getCustomFieldDateTimeTo())
					.dateTimeFromTo(MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds, dto.getCustomFieldDateTimeWithSeconds(), dto.getCustomFieldDateTimeWithSecondsTo());
		} else {
			fb.number(MyExample4300WithDrilldownDTO_.customFieldNumber, dto.getCustomFieldNumber())
					.money(MyExample4300WithDrilldownDTO_.customFieldMoney, dto.getCustomFieldMoney())
					.percent(MyExample4300WithDrilldownDTO_.customFieldPercent, dto.getCustomFieldPercent())
					.date(MyExample4300WithDrilldownDTO_.customFieldDate, day(dto.getCustomFieldDate()))
					.dateTime(MyExample4300WithDrilldownDTO_.customFieldDateTime, dto.getCustomFieldDateTime())
					.dateTime(MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds, dto.getCustomFieldDateTimeWithSeconds());
		}
	}

	private static LocalDate day(LocalDateTime date) {
		return date == null ? null : date.toLocalDate();
	}

	public static long activeConditions(MyExample4300PostActionWithCustomBuilderDTO dto) {
		return parameters(dto).getParameters().keySet().stream().map(key -> key.substring(0, key.indexOf('.'))).distinct().count();
	}
}

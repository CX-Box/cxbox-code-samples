package org.demo.documentation.feature.drilldown.drilldownfilter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.cxbox.core.config.JacksonConfig;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.dao.BaseDAO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.service.drilldown.PlatformDrilldownService;
import org.cxbox.core.service.drilldown.filter.FC;
import org.cxbox.core.service.drilldown.filter.PlatformDrilldownFilterService;
import org.cxbox.core.util.SpringBeanUtils;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig({JacksonConfig.class, SpringBeanUtils.class, PlatformDrilldownFilterService.class})
class DashboardFiltersTest {
	private static String decode(String value) {
		return URLDecoder.decode(value, StandardCharsets.UTF_8);
	}

	/**
	 * Replay both URL query layers, just as the UI does before requesting the filtered BC.
	 */
	private Map<String, String> replay(MyExample4300PostActionWithCustomBuilderDTO dto) throws Exception {
		FC fc = new FC().add(CxboxMyExample4300Controller.myExample4300DrillDown,
				MyExample4300WithDrilldownDTO.class, fb -> MyExample4300DashboardFilters.apply(fb, dto));
		String query = new PlatformDrilldownService(new PlatformDrilldownFilterService()).formUrlFilterPart(fc);
		Map<String, String> parts = new ObjectMapper().readValue(decode(query.substring("filters=".length())), new TypeReference<>() {
		});
		Map<String, String> result = new LinkedHashMap<>();
		for (String pair : parts.get("myExample4300DrillDown").split("&")) {
			int equals = pair.indexOf('=');
			result.put(decode(pair.substring(0, equals)), decode(pair.substring(equals + 1)));
		}
		return result;
	}

	@Test
	void emptyCollectionsAreAnEmptyForm() {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		dto.setCustomFieldMultivalue(new MultivalueField(List.of()));
		dto.setCustomFieldMultipleSelect(new MultivalueField(List.of()));
		dto.setCustomFieldMultivalueHover(new MultivalueField(List.of()));
		assertThat(MyExample4300DashboardFilters.isEmpty(dto)).isTrue();
	}

	@Test
	void falseIsAFilter() throws Exception {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		dto.setCustomFieldCheckbox(false);
		assertThat(MyExample4300DashboardFilters.isEmpty(dto)).isFalse();
		assertThat(replay(dto)).containsExactlyEntriesOf(Map.of("customFieldCheckbox.specified", "false"));
	}

	@Test
	void stringsKeepSpecialCharacters() throws Exception {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		String value = "Кириллица & + = 100% \"quotes\" \\ path";
		dto.setCustomField(value);
		dto.setCustomFieldText(value);
		dto.setCustomFieldHint(value);
		dto.setCustomFieldHidden(value);
		dto.setCustomFieldPickList(value);
		dto.setCustomFieldInlinePickList(value);
		dto.setCustomFieldFileUpload(value);
		assertThat(replay(dto)).hasSize(7).allSatisfy((key, actual) -> assertThat(actual).isEqualTo(value));
	}

	@Test
	void numericAndDictionaryFieldsAreCombined() throws Exception {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		dto.setCustomFieldNumber(450L);
		dto.setCustomFieldPercent(60L);
		dto.setCustomFieldMoney(300.25);
		dto.setCustomFieldDictionary(CustomField4300DictionaryEnum.THREE_DE);
		dto.setCustomFieldRadio(CustomField4300RadioEnum.THREE_RE);
		assertThat(replay(dto)).containsEntry("customFieldNumber.equals", "450")
				.containsEntry("customFieldPercent.equals", "60").containsEntry("customFieldMoney.equals", "300.25")
				.containsEntry("customFieldDictionary.equalsOneOf", "[\"ThreeDE\"]")
				.containsEntry("customFieldRadio.equalsOneOf", "[\"ThreeRE\"]");
	}

	@Test
	void collectionValuesStaySeparateAndKeepTheirIds() throws Exception {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		dto.setCustomFieldMultivalue(new MultivalueField(List.of(new MultivalueFieldSingleValue("7", "ignored"), new MultivalueFieldSingleValue("8", "ignored"))));
		dto.setCustomFieldMultivalueHover(dto.getCustomFieldMultivalue());
		dto.setCustomFieldMultipleSelect(new MultivalueField(List.of(new MultivalueFieldSingleValue("1", "With spaces"), new MultivalueFieldSingleValue("2", "With, comma"))));
		assertThat(replay(dto)).containsEntry("customFieldMultivalue.equalsOneOf", "[\"7\",\"8\"]")
				.containsEntry("customFieldMultivalueHover.equalsOneOf", "[\"7\",\"8\"]")
				.containsEntry("customFieldMultipleSelect.equalsOneOf", "[\"With spaces\",\"With, comma\"]");
	}

	@Test
	void severalDictionaryAndRadioValuesRemainAlternatives() throws Exception {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		dto.setDictionaryValues(new MultivalueField(List.of(
				new MultivalueFieldSingleValue("CUSTOM_FIELD4300_DICTIONARY3", "CustomField4300Dictionary3"),
				new MultivalueFieldSingleValue("CUSTOM_FIELD4300_DICTIONARY5", "CustomField4300Dictionary5"))));
		dto.setDictionaryEnumValues(new MultivalueField(List.of(
				new MultivalueFieldSingleValue("THREE_DE", "ThreeDE"), new MultivalueFieldSingleValue("FIVE_DE", "FiveDE"))));
		dto.setRadioValues(new MultivalueField(List.of(
				new MultivalueFieldSingleValue("THREE_RE", "ThreeRE"), new MultivalueFieldSingleValue("FIVE_RE", "FiveRE"))));
		assertThat(replay(dto)).containsEntry("customField4300Dictionary.equalsOneOf", "[\"CUSTOM_FIELD4300_DICTIONARY3\",\"CUSTOM_FIELD4300_DICTIONARY5\"]")
				.containsEntry("customFieldDictionary.equalsOneOf", "[\"ThreeDE\",\"FiveDE\"]")
				.containsEntry("customFieldRadio.equalsOneOf", "[\"ThreeRE\",\"FiveRE\"]");
	}

	@Test
	void dateAndTimeUseIndependentRanges() throws Exception {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO();
		var date = LocalDateTime.of(2025, 7, 4, 9, 25, 55);
		dto.setCustomFieldDate(date);
		dto.setCustomFieldDateTime(date);
		dto.setCustomFieldDateTimeWithSeconds(date);
		assertThat(replay(dto)).hasSize(6)
				.containsEntry("customFieldDate.greaterOrEqualThan", "2025-07-04T00:00:00")
				.containsEntry("customFieldDate.lessOrEqualThan", "2025-07-04T23:59:59")
				.containsEntry("customFieldDateTime.greaterOrEqualThan", "2025-07-04T09:25:55");
	}

	@Test
	void metadataReadCountsTheSavedFormEvenWhenRequestHasNoFilters() {
		BaseDAO base = mock(BaseDAO.class);
		var forms = mock(MyEntity4300PostActionWithCustomBuilderRepository.class);
		var entity = new MyEntity4300PostActionWithCustomBuilder();
		entity.setId(42L);
		entity.setCustomField("R&D + QA");
		when(forms.findById(42L)).thenReturn(java.util.Optional.of(entity));
		var bc = mock(org.cxbox.core.crudma.bc.BusinessComponent.class);
		when(bc.getParentIdAsLong()).thenReturn(42L);
		when(bc.getId()).thenReturn("matching");
		when(bc.getParameters()).thenReturn(QueryParameters.emptyQueryParameters());
		when(base.getCount(eq(MyEntityWithDrilldown4300.class), eq(MyExample4300WithDrilldownDTO.class), isNull(), any(QueryParameters.class))).thenAnswer(invocation -> {
			QueryParameters actual = invocation.getArgument(3);
			return "R&D + QA".equals(actual.getParameter("customField.contains")) ? 1L : 5L;
		});
		assertThat(new MyExample4300DashboardStatsDao(base, forms).getByIdIgnoringFirstLevelCache(bc).getValue()).isEqualTo(1L);
	}

	@Test
	void statsCountAllMatchesInsteadOfTheCurrentPage() {
		BaseDAO base = mock(BaseDAO.class);
		var forms = mock(MyEntity4300PostActionWithCustomBuilderRepository.class);
		var entity = new MyEntity4300PostActionWithCustomBuilder();
		entity.setId(42L);
		entity.setCustomField("Field");
		when(forms.findById(42L)).thenReturn(java.util.Optional.of(entity));
		var bc = mock(org.cxbox.core.crudma.bc.BusinessComponent.class);
		when(bc.getParentIdAsLong()).thenReturn(42L);
		when(base.getCount(eq(MyEntityWithDrilldown4300.class), eq(MyExample4300WithDrilldownDTO.class), isNull(), any(QueryParameters.class))).thenReturn(5L);
		var page = new MyExample4300DashboardStatsDao(base, forms).getList(bc, new QueryParameters(Map.of("_limit", "1")));
		assertThat(page.getContent()).extracting(MyExample4300DashboardStatsDTO::getId).containsExactly("matching", "total", "conditions");
		assertThat(page.getContent()).extracting(MyExample4300DashboardStatsDTO::getValue).containsExactly(5L, 5L, 1L);
	}
}

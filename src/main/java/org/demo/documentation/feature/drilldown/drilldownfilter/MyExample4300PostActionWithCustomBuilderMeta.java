package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.api.data.dto.rowmeta.FieldDTO;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.feature.drilldown.drilldownfilter.dictionary.CustomField4300Dictionary;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyExample4300PostActionWithCustomBuilderMeta extends FieldMetaBuilder<MyExample4300PostActionWithCustomBuilderDTO> {
	private final DictionaryProvider dictionaryProvider;

	@Override
	public void buildRowDependentMeta(final RowDependentFieldsMeta<MyExample4300PostActionWithCustomBuilderDTO> fields,
									  final InnerBcDescription bcDescription, final Long id,
									  final Long parentId) {
		fields.setDictionaryValues(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryValue);
		fields.setConcreteValues(MyExample4300PostActionWithCustomBuilderDTO_.checkboxFilter, java.util.List.of(new SimpleDictionary("All", "All"), new SimpleDictionary("Yes", "Yes"), new SimpleDictionary("No", "No")));
		fields.setConcreteValues(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryValues,
				dictionaryProvider.getAll(CustomField4300Dictionary.class)
						.stream().sorted(Comparator.comparing(Dictionary::key))
						.map(value -> new SimpleDictionary(value.key(), dictionaryProvider.lookupValue(value).getValue())).toList());
		fields.setConcreteValues(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryEnumValues,
				Arrays.stream(CustomField4300DictionaryEnum.values()).map(value -> new SimpleDictionary(value.name(), value.getValue())).toList());
		fields.setPlaceholder(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryValues, "Overrides the single Dictionary selection");
		fields.setPlaceholder(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryEnumValues, "Overrides the single Enum selection");
		fields.setPlaceholder(MyExample4300PostActionWithCustomBuilderDTO_.radioValues, "Overrides the single Radio selection");
		fields.setConcreteValues(MyExample4300PostActionWithCustomBuilderDTO_.radioValues,
				Arrays.stream(CustomField4300RadioEnum.values()).map(value -> new SimpleDictionary(value.name(), value.getValue())).toList());
		var upperBounds = Set.of("customFieldNumberTo", "customFieldMoneyTo", "customFieldPercentTo", "customFieldDateTo", "customFieldDateTimeTo", "customFieldDateTimeWithSecondsTo");
		for (final FieldDTO field : fields) {
			if (upperBounds.contains(field.getKey())) {
				field.setHidden(!fields.getCurrentValue(MyExample4300PostActionWithCustomBuilderDTO_.rangeFilters).orElse(false));
			}
			field.setDisabled(false);
		}
	}

	@Override
	public void buildIndependentMeta(final FieldsMeta<MyExample4300PostActionWithCustomBuilderDTO> fields, final InnerBcDescription bcDescription,
									 final Long parentId) {
		fields.setConcreteValues(
				MyExample4300PostActionWithCustomBuilderDTO_.customFieldMultipleSelect, Arrays.stream(CustomField4300MultipleSelectEnum.values())
						.map(CustomField4300MultipleSelectEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);
		fields.setForceActive(MyExample4300PostActionWithCustomBuilderDTO_.rangeFilters);
		fields.setEnumValues(MyExample4300PostActionWithCustomBuilderDTO_.customFieldRadio, CustomField4300RadioEnum.values());
		fields.setEnumFilterValues(fields, MyExample4300PostActionWithCustomBuilderDTO_.customFieldRadio, CustomField4300RadioEnum.values());
		fields.setEnumFilterValues(fields, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDictionary, CustomField4300DictionaryEnum.values());
		fields.setEnumValues(MyExample4300PostActionWithCustomBuilderDTO_.customFieldDictionary, CustomField4300DictionaryEnum.values());
		for (final FieldDTO field : fields) {
			field.setFilterable(true);
			field.setDisabled(false);
		}
	}

}

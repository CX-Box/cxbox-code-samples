package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.api.data.dto.rowmeta.FieldDTO;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyExample4300PostActionWithCustomBuilderMeta extends FieldMetaBuilder<MyExample4300PostActionWithCustomBuilderDTO> {

	@Override
	public void buildRowDependentMeta(final RowDependentFieldsMeta<MyExample4300PostActionWithCustomBuilderDTO> fields,
									  final InnerBcDescription bcDescription, final Long id,
									  final Long parentId) {
		for (final FieldDTO field : fields) {
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

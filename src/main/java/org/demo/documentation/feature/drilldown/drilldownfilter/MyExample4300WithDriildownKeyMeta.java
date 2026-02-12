package org.demo.documentation.feature.drilldown.drilldownfilter;

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
public class MyExample4300WithDriildownKeyMeta extends FieldMetaBuilder<MyExample4300WithDrilldownKeyDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4300WithDrilldownKeyDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		// not need implementation

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4300WithDrilldownKeyDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setConcreteFilterValues(
				MyExample4300WithDrilldownKeyDTO_.customFieldMultipleSelect, Arrays.stream(CustomField4300MultipleSelectEnum.values())
						.map(CustomField4300MultipleSelectEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample4300WithDrilldownKeyDTO_.customFieldRadio, Arrays.stream(CustomField4300RadioEnum.values())
						.map(CustomField4300RadioEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample4300WithDrilldownKeyDTO_.customFieldDictionary, Arrays.stream(CustomField4300DictionaryEnum.values())
						.map(CustomField4300DictionaryEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);
		fields.setDictionaryFilterValues(MyExample4300WithDrilldownKeyDTO_.customField4300Dictionary);
		for (final FieldDTO field : fields) {
			field.setFilterable(true);
		}
	}

}

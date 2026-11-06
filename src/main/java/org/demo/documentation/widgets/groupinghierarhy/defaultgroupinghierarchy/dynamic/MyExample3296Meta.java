package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.hierarhy.grouping.Hierarchy;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3296Meta extends FieldMetaBuilder<MyExample3296DTO> {

	private final MyEntity3296ConfigRepository configRepository;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3296DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample3296DTO_.customFieldDictionaryLevelTwo, CustomFieldDictionaryLevelTwoEnum.values());
		fields.setEnabled(MyExample3296DTO_.customFieldDictionaryLevelTwo);
		fields.setEnumValues(MyExample3296DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3296DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3296DTO_.customField);
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3296DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.setEnumFilterValues(fields, MyExample3296DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3296DTO_.customFieldDictionary);
		fields.setEnumFilterValues(
				fields,
				MyExample3296DTO_.customFieldDictionaryLevelTwo,
				CustomFieldDictionaryLevelTwoEnum.values()
		);
		fields.enableFilter(MyExample3296DTO_.customFieldDictionaryLevelTwo);

		// default hierarchy is loaded from DB (it can be a microservice, a cache etc.)
		// level 1 value -> rows with level 2 values
		Map<CustomFieldDictionaryEnum, List<MyEntity3296Config>> external = configRepository.findAll().stream()
				.filter(cfg -> cfg.getCustomFieldDictionary() != null)
				.collect(Collectors.groupingBy(
						MyEntity3296Config::getCustomFieldDictionary,
						LinkedHashMap::new,
						Collectors.toList()
				));

		fields.defaultGroupingHierarchy(
				MyExample3296DTO_.customFieldDictionary,
				MyExample3296DTO_.customFieldDictionaryLevelTwo,
				lvl1 -> external.entrySet().stream().collect(Hierarchy.toHierarchyWithCfg(
						// value of level 1
						Entry::getKey,
						// options of level 1 group
						(lvl1Entry, cfg) -> cfg.defaultExpanded(
								lvl1Entry.getValue().stream().anyMatch(c -> Boolean.TRUE.equals(c.getDefaultExpanded()))
						),
						// children of level 1 group = level 2 values
						(lvl1Entry, lvl2) -> lvl1Entry.getValue().stream()
								.map(MyEntity3296Config::getCustomFieldDictionaryLevelTwo)
								.filter(Objects::nonNull)
								.distinct()
								.collect(Hierarchy.toHierarchy(lvl2Value -> lvl2Value))
				))
		);
	}
	// --8<-- [end:buildIndependentMeta]

}

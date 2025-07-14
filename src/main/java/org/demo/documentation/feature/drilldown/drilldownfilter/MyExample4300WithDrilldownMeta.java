package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.api.data.dto.rowmeta.FieldDTO;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;

@Service
@RequiredArgsConstructor
public class MyExample4300WithDrilldownMeta extends FieldMetaBuilder<MyExample4300WithDrilldownDTO> {

	public static final String SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST = "/screen/MyExample4300/view/MyExample4300DrillDown/";

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4300WithDrilldownDTO> fields, InnerBcDescription bcDescription,
																		Long id, Long parentId) {
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldHidden);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldText);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldDateTime);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldCheckbox);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldDate);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds);
		fields.setEnumValues(MyExample4300WithDrilldownDTO_.customFieldDictionary, CustomField4300DictionaryEnum.values());
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldDictionary);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldFileUploadId);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldFileUpload);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldNumber);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldPercent);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldMoney);
		fields.setEnumValues(MyExample4300WithDrilldownDTO_.customFieldRadio, CustomField4300RadioEnum.values());
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldRadio);
		fields.setConcreteValues(
				MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, Arrays.stream(CustomField4300MultipleSelectEnum.values())
						.map(CustomField4300MultipleSelectEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldMultipleSelect);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customFieldHint);
		fields.setEnabled(MyExample4300WithDrilldownDTO_.customField);

		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldHidden, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.input(
												MyExample4300WithDrilldownDTO_.customFieldHidden,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldHidden).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldText, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.input(
												MyExample4300WithDrilldownDTO_.customFieldText,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldText).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldDateTime, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.dateTime(
												MyExample4300WithDrilldownDTO_.customFieldDateTime,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldDateTime).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldCheckbox, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.checkbox(
												MyExample4300WithDrilldownDTO_.customFieldCheckbox,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldCheckbox).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldDate, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.date(
												MyExample4300WithDrilldownDTO_.customFieldDate,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldDate).map(LocalDateTime::toLocalDate).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.dateTime(
												MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldDictionary, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.dictionaryEnum(
												MyExample4300WithDrilldownDTO_.customFieldDictionary,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldDictionary).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldFileUploadId, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.fileUpload(
												MyExample4300WithDrilldownDTO_.customFieldFileUploadId,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldFileUploadId).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldFileUpload, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.fileUpload(
												MyExample4300WithDrilldownDTO_.customFieldFileUpload,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldFileUpload).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldNumber, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.number(
												MyExample4300WithDrilldownDTO_.customFieldNumber,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldNumber).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldPercent, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.percent(
												MyExample4300WithDrilldownDTO_.customFieldPercent,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldPercent).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldMoney, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.money(
												MyExample4300WithDrilldownDTO_.customFieldMoney,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldMoney).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldRadio, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.radio(
												MyExample4300WithDrilldownDTO_.customFieldRadio,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldRadio).map(List::of).orElse(
														Collections.emptyList())
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.multipleSelect(
												MyExample4300WithDrilldownDTO_.customFieldMultipleSelect,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldMultipleSelect).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldHint, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.input(
												MyExample4300WithDrilldownDTO_.customFieldHint,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldHint).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customField, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.input(
												MyExample4300WithDrilldownDTO_.customField,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customField).orElse(null)
										)
						)
		);

		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldMultivalueHover, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.multivalueHover(
												MyExample4300WithDrilldownDTO_.customFieldMultivalueHover,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldMultivalueHover).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldMultivalue, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.multiValue(
												MyExample4300WithDrilldownDTO_.customFieldMultivalue,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldMultivalue).orElse(null)
										)
						)
		);

		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldMultivalue, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.multiValue(
												MyExample4300WithDrilldownDTO_.customFieldMultivalue,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldMultivalue).orElse(null)
										)
						)
		);

		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.multipleSelect(
												MyExample4300WithDrilldownDTO_.customFieldMultipleSelect,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldMultipleSelect).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldPickList, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.pickList(
												MyExample4300WithDrilldownDTO_.customFieldPickList,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldPickList).orElse(null)
										)
						)
		);
		fields.setDrilldownWithFilter(
				MyExample4300WithDrilldownDTO_.customFieldInlinePickList, DrillDownType.INNER, SCREEN_MY_EXAMPLE_4300_VIEW_MY_EXAMPLE_4300_LIST, fc ->
						fc.add(
								CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class, fb ->
										fb.inlinePickList(
												MyExample4300WithDrilldownDTO_.customFieldInlinePickList,
												fields.getCurrentValue(MyExample4300WithDrilldownDTO_.customFieldInlinePickList).orElse(null)
										)
						)
		);

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4300WithDrilldownDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setConcreteValues(
				MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, Arrays.stream(CustomField4300MultipleSelectEnum.values())
						.map(CustomField4300MultipleSelectEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, Arrays.stream(CustomField4300MultipleSelectEnum.values())
						.map(CustomField4300MultipleSelectEnum::getValue)
						.map(e -> new SimpleDictionary(e, e))
						.toList()
		);

		fields.setEnumFilterValues(fields, MyExample4300WithDrilldownDTO_.customFieldRadioMultiField, CustomField4300RadioEnum.values());
		fields.setEnumFilterValues(fields, MyExample4300WithDrilldownDTO_.customFieldRadio, CustomField4300RadioEnum.values());
		fields.setEnumFilterValues(fields, MyExample4300WithDrilldownDTO_.customFieldDictionary, CustomField4300DictionaryEnum.values());
		for (final FieldDTO field : fields) {
			field.setFilterable(true);
		}
	}

}

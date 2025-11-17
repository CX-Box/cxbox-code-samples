package org.demo.documentation.other.widgetEditStyles.colortitle;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesColorDictionaryEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesColorRadioEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesTestEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class WidgetStylesMeta extends FieldMetaBuilder<WidgetStylesDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<WidgetStylesDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(WidgetStylesDTO_.hidden);
		fields.setEnabled(WidgetStylesDTO_.time);
		if (CxboxWidgetStylesController.widgetStylesNone.isBc(bcDescription)) {
			fields.setConcreteValues(WidgetStylesDTO_.multipleSelect, Arrays.stream(WidgetStylesTestEnum.values())
					.map(WidgetStylesTestEnum::getValue)
					.map(e -> new SimpleDictionary(e, e))
					.toList());
			fields.setEnumValues(WidgetStylesDTO_.customFieldColorDictionary, WidgetStylesColorDictionaryEnum.values());
			fields.setEnumValues(WidgetStylesDTO_.customFieldColorRadio, WidgetStylesColorRadioEnum.values());
			fields.setRequired(WidgetStylesDTO_.customField);
			fields.setConcreteValues( WidgetStylesDTO_.multipleSelect, Arrays.stream(WidgetStylesTestEnum.values())
					.map(WidgetStylesTestEnum::getValue)
					.map(e -> new SimpleDictionary(e, e))
					.toList());

		} else {
			fields.setEnabled(WidgetStylesDTO_.hint);
			fields.setEnabled(WidgetStylesDTO_.suggestion);
			fields.setEnabled(WidgetStylesDTO_.suggestionDate);
			fields.setEnabled(WidgetStylesDTO_.multipleSelect);
			fields.setEnabled(WidgetStylesDTO_.multipleSelect);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorInput);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorText);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorDateTime);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorCheckbox);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorDate);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorDateTimeWithSeconds);
			fields.setEnumValues(WidgetStylesDTO_.customFieldColorDictionary, WidgetStylesColorDictionaryEnum.values());
			fields.setEnabled(WidgetStylesDTO_.customFieldColorDictionary);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorFileUploadeId);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorFileUploade);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorNumber);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorPercent);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorMoney);
			fields.setEnumValues(WidgetStylesDTO_.customFieldColorRadio, WidgetStylesColorRadioEnum.values());
			fields.setEnabled(WidgetStylesDTO_.customFieldColorRadio);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorPicklistId);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorPicklist);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorInlinePicklistId);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorInlinePicklist);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorMultivalue);
			fields.setEnabled(WidgetStylesDTO_.customFieldColorMultivalueHover);
			fields.setEnabled(WidgetStylesDTO_.customField);
			fields.setEnabled(WidgetStylesDTO_.multipleSelect);
			fields.setRequired(WidgetStylesDTO_.customField);
			fields.setConcreteValues(WidgetStylesDTO_.multipleSelect, Arrays.stream(WidgetStylesTestEnum.values())
					.map(WidgetStylesTestEnum::getValue)
					.map(e -> new SimpleDictionary(e, e))
					.toList());
		}
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<WidgetStylesDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(WidgetStylesDTO_.time);
		fields.setConcreteFilterValues(WidgetStylesDTO_.multipleSelect, Arrays.stream(WidgetStylesTestEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.collect(Collectors.toList()));
		fields.enableFilter(WidgetStylesDTO_.multipleSelect);
		fields.setConcreteFilterValues(WidgetStylesDTO_.multipleSelect, Arrays.stream(WidgetStylesTestEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.collect(Collectors.toList()));
		fields.enableFilter(WidgetStylesDTO_.multipleSelect);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorInput);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorText);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorDateTime);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorCheckbox);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorDate);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, WidgetStylesDTO_.customFieldColorDictionary, WidgetStylesColorDictionaryEnum.values());
		fields.enableFilter(WidgetStylesDTO_.customFieldColorDictionary);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorFileUploade);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorNumber);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorPercent);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorMoney);
		fields.setEnumFilterValues(fields, WidgetStylesDTO_.customFieldColorRadio, WidgetStylesColorRadioEnum.values());
		fields.enableFilter(WidgetStylesDTO_.customFieldColorRadio);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorPicklist);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorInlinePicklist);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorMultivalue);
		fields.enableFilter(WidgetStylesDTO_.customFieldColorMultivalueHover);
		fields.setForceActive(
                WidgetStylesDTO_.suggestion,
                WidgetStylesDTO_.hint,
                WidgetStylesDTO_.hidden,
				WidgetStylesDTO_.multipleSelect,
				WidgetStylesDTO_.customFieldColorInput,
				WidgetStylesDTO_.customFieldColorText,
				WidgetStylesDTO_.customFieldColorDateTime,
				WidgetStylesDTO_.customFieldColorCheckbox,
				WidgetStylesDTO_.customFieldColorDate,
				WidgetStylesDTO_.customFieldColorDateTimeWithSeconds,
				WidgetStylesDTO_.customFieldColorDictionary,
				WidgetStylesDTO_.customFieldColorFileUploade,
				WidgetStylesDTO_.customFieldColorNumber,
				WidgetStylesDTO_.customFieldColorPercent,
				WidgetStylesDTO_.customFieldColorMoney,
				WidgetStylesDTO_.customFieldColorRadio,
				WidgetStylesDTO_.customFieldColorPicklist,
				WidgetStylesDTO_.customFieldColorInlinePicklist,
				WidgetStylesDTO_.customFieldColorMultivalue,
				WidgetStylesDTO_.customFieldColorMultivalueHover
		);
	}

}
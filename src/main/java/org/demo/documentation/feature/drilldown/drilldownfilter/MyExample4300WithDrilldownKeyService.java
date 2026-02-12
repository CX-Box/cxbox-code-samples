package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.drilldown.PlatformDrilldownService;
import org.cxbox.core.service.drilldown.filter.FC;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyExample4300WithDrilldownKeyService extends
		VersionAwareResponseService<MyExample4300WithDrilldownKeyDTO, MyEntity4300WithDriildownKey> {

	private final MyEntity4300WithDriildownKeyRepository repository;

	private final PlatformDrilldownService drilldownService;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300WithDriildownKeyMeta> meta = MyExample4300WithDriildownKeyMeta.class;

	@Override
	protected CreateResult<MyExample4300WithDrilldownKeyDTO> doCreateEntity(MyEntity4300WithDriildownKey entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected MyExample4300WithDrilldownKeyDTO entityToDto(final BusinessComponent bc, final MyEntity4300WithDriildownKey entity) {
		MyExample4300WithDrilldownKeyDTO dto = super.entityToDto(bc, entity);
		String s = "screen/MyExample4300/view/MyExample4300DrilldownKey?" + drilldownService.formUrlFilterPart(createFC(dto));
		dto.setCustomFieldDrilldownKey(s);
		dto.setCustomFieldSuggestionPickListDrilldownKey(s);
		dto.setCustomFieldMultivalueHoverDrilldownKey(s);
		dto.setCustomFieldHintDrilldownKey(s);
		dto.setCustomFieldMultivalueDrilldownKey(s);
		dto.setCustomFieldMultipleSelectDrilldownKey(s);
		dto.setCustomFieldRadioMultiFieldDrilldownKey(s);
		dto.setCustomFieldInlinePickListDrilldownKey(s);
		dto.setCustomFieldInlinePickListDrilldownKey(s);
		dto.setCustomFieldRadioDrilldownKey(s);
		dto.setCustomFieldMoneyDrilldownKey(s);
		dto.setCustomFieldPercentDrilldownKey(s);
		dto.setCustomFieldDrilldownKey(s);
		dto.setCustomFieldNumberDrillDownKey(s);
		dto.setCustomFieldNumberDrillDownKey(s);
		dto.setCustomFieldFileUploadDrilldownKey(s);
		dto.setCustomFieldDictionaryDrilldownKey(s);
		dto.setCustomField4300DictionaryDrillDownKey(s);
		dto.setCustomFieldDateTimeDrilldownKey(s);
		dto.setCustomFieldDateDrilldownKey(s);
		dto.setCustomFieldCheckboxDrilldownKey(s);
		dto.setCustomFieldDateTimeDrilldownKey(s);
		dto.setCustomFieldTextDrilldownKey(s);
		dto.setCustomFieldRadioMultiFieldDrilldownKey(s);
		return dto;
	}

	private FC createFC(MyExample4300WithDrilldownKeyDTO dto) {
		FC fc = new FC();
		fc.add(
				CxboxMyExample4300Controller.myExample4300DrilldownKey,
				MyExample4300WithDrilldownKeyDTO.class, Custom4300FilterBuilder.type(), fb -> fb
						.customMultiValue(MyExample4300WithDrilldownKeyDTO_.customFieldMultivalue, dto.getCustomFieldMultivalue())
						.customMultipleSelect(MyExample4300WithDrilldownKeyDTO_.customFieldMultipleSelect, dto.getCustomFieldMultipleSelect())
						.customInlinePickList(MyExample4300WithDrilldownKeyDTO_.customFieldInlinePickList, dto.getCustomFieldInlinePickList())
						.customPickList(MyExample4300WithDrilldownKeyDTO_.customFieldPickList, dto.getCustomFieldPickList())
						.customRadio(
								MyExample4300WithDrilldownKeyDTO_.customFieldRadio,
								Optional.ofNullable(dto.getCustomFieldRadio()).map(List::of).orElse(List.of())
						)
						.customMoney(MyExample4300WithDrilldownKeyDTO_.customFieldMoney, dto.getCustomFieldMoney())
						.customPercent(MyExample4300WithDrilldownKeyDTO_.customFieldPercent, dto.getCustomFieldPercent())
						.customNumber(MyExample4300WithDrilldownKeyDTO_.customFieldNumber, dto.getCustomFieldNumber())
						.customFileUpload(MyExample4300WithDrilldownKeyDTO_.customFieldFileUpload, dto.getCustomFieldFileUpload())
						.customDateTime(MyExample4300WithDrilldownKeyDTO_.customFieldDateTimeWithSeconds, dto.getCustomFieldDateTimeWithSeconds())
						.customDate(
								MyExample4300WithDrilldownKeyDTO_.customFieldDate,
								Optional.ofNullable(dto.getCustomFieldDate()).map(LocalDate::from).orElse(null)
						)
						.customCheckbox(MyExample4300WithDrilldownKeyDTO_.customFieldCheckbox, dto.getCustomFieldCheckbox())
						.customDateTime(MyExample4300WithDrilldownKeyDTO_.customFieldDateTime, dto.getCustomFieldDateTime())
						.customText(MyExample4300WithDrilldownKeyDTO_.customFieldText, dto.getCustomFieldText())
						.customInput(MyExample4300WithDrilldownKeyDTO_.customField, dto.getCustomField())
		);
		return fc;
	}

	@Override
	protected ActionResultDTO<MyExample4300WithDrilldownKeyDTO> doUpdateEntity(MyEntity4300WithDriildownKey entity,
																			   MyExample4300WithDrilldownKeyDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300WithDrilldownKeyDTO> getActions() {
		return Actions.<MyExample4300WithDrilldownKeyDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}

package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyExample4300WithDrillDownService extends VersionAwareResponseService<MyExample4300WithDrilldownDTO, MyEntityWithDrilldown4300> {

	private final MyEntityWithDrilldown4300Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300WithDrilldownMeta> meta = MyExample4300WithDrilldownMeta.class;

	@Override
	protected CreateResult<MyExample4300WithDrilldownDTO> doCreateEntity(MyEntityWithDrilldown4300 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4300WithDrilldownDTO> doUpdateEntity(MyEntityWithDrilldown4300 entity, MyExample4300WithDrilldownDTO data,
																			BusinessComponent bc) {
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldHidden, entity::setCustomFieldHidden);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldDateTime, entity::setCustomFieldDateTime);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldDate, entity::setCustomFieldDate);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldPercent, entity::setCustomFieldPercent);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldRadio, entity::setCustomFieldRadio);
		if (data.isFieldChanged(MyExample4300WithDrilldownDTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomField4300MultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		setIfChanged(data, MyExample4300WithDrilldownDTO_.customFieldHint, entity::setCustomFieldHint);
		if (data.isFieldChanged(MyExample4300WithDrilldownDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300WithDrilldownDTO> getActions() {
		return Actions.<MyExample4300WithDrilldownDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}

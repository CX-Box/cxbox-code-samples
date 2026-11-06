package org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3297Service extends VersionAwareResponseService<MyExample3297DTO, MyEntity3297> {

	private final MyEntity3297Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3297Meta> meta = MyExample3297Meta.class;

	@Override
	protected CreateResult<MyExample3297DTO> doCreateEntity(MyEntity3297 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3297DTO> doUpdateEntity(MyEntity3297 entity, MyExample3297DTO data,
			BusinessComponent bc) {
		setIfChanged(data, MyExample3297DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample3297DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample3297DTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample3297DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3297DTO_.customFieldPercent, entity::setCustomFieldPercent);
		setIfChanged(data, MyExample3297DTO_.customFieldDate, entity::setCustomFieldDate);
		setIfChanged(data, MyExample3297DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
		setIfChanged(data, MyExample3297DTO_.customFieldInput, entity::setCustomFieldInput);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3297DTO> getActions() {
		return Actions.<MyExample3297DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}

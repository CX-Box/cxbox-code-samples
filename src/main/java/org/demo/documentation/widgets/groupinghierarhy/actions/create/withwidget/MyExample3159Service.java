package org.demo.documentation.widgets.groupinghierarhy.actions.create.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3159Service extends VersionAwareResponseService<MyExample3159DTO, MyEntity3159> {

	private final MyEntity3159Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3159Meta> meta = MyExample3159Meta.class;

	@Override
	protected CreateResult<MyExample3159DTO> doCreateEntity(MyEntity3159 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3159DTO> doUpdateEntity(MyEntity3159 entity, MyExample3159DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3159DTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample3159DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		if (data.isFieldChanged(MyExample3159DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3159DTO> getActions() {
		return Actions.<MyExample3159DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}


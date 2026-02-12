package org.demo.documentation.widgets.picklist.actions.cancelcreate.basic;

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
@Getter
@Service
public class MyEntity3198PickPickService extends VersionAwareResponseService<MyEntity3198PickPickDTO, MyEntity3198Pick> {
	private final MyEntity3198PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3198PickPickMeta> meta = MyEntity3198PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3198PickPickDTO> doCreateEntity(MyEntity3198Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3198PickPickDTO> doUpdateEntity(MyEntity3198Pick entity, MyEntity3198PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3198PickPickDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3198PickPickDTO> getActions() {
		return Actions.<MyEntity3198PickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.widgets.picktree.actions.cancelcreate.basic;

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
public class MyEntity3356PickPickService extends VersionAwareResponseService<MyEntity3356PickPickDTO, MyEntity3356Pick> {
	private final MyEntity3356PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3356PickPickMeta> meta = MyEntity3356PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3356PickPickDTO> doCreateEntity(MyEntity3356Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3356PickPickDTO> doUpdateEntity(MyEntity3356Pick entity, MyEntity3356PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3356PickPickDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3356PickPickDTO> getActions() {
		return Actions.<MyEntity3356PickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}
	// --8<-- [end:getActions]

}
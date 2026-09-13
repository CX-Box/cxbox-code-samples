package org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.picktree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.MyEntity3353Pick;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.MyEntity3353PickRepository;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3353PickPickService extends VersionAwareResponseService<MyEntity3353PickPickDTO, MyEntity3353Pick> {
	private final MyEntity3353PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3353PickPickMeta> meta = MyEntity3353PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3353PickPickDTO> doCreateEntity(MyEntity3353Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyEntity3353PickPickDTO> doUpdateEntity(MyEntity3353Pick entity, MyEntity3353PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3353PickPickDTO_.customField, entity::setCustomField);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3353PickPickDTO> getActions() {
		return Actions.<MyEntity3353PickPickDTO>builder()
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}
	// --8<-- [end:getActions]

}
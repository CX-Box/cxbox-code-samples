package org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup;

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
public class MyEntity3355PickPickService extends VersionAwareResponseService<MyEntity3355PickPickDTO, MyEntity3355Pick> {
	private final MyEntity3355PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3355PickPickMeta> meta = MyEntity3355PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3355PickPickDTO> doCreateEntity(MyEntity3355Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]

	@Override
	protected ActionResultDTO<MyEntity3355PickPickDTO> doUpdateEntity(MyEntity3355Pick entity, MyEntity3355PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3355PickPickDTO_.customField, entity::setCustomField);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3355PickPickDTO> getActions() {
		return Actions.<MyEntity3355PickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
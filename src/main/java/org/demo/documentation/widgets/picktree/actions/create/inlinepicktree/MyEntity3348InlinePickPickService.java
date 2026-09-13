package org.demo.documentation.widgets.picktree.actions.create.inlinepicktree;

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
public class MyEntity3348InlinePickPickService extends VersionAwareResponseService<MyEntity3348InlinePickPickDTO, MyEntity3348InlinePick> {
	private final MyEntity3348InlinePickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3348InlinePickPickMeta> meta = MyEntity3348InlinePickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3348InlinePickPickDTO> doCreateEntity(MyEntity3348InlinePick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3348InlinePickPickDTO> doUpdateEntity(MyEntity3348InlinePick entity, MyEntity3348InlinePickPickDTO data,
																			BusinessComponent bc) {
		setIfChanged(data, MyEntity3348InlinePickPickDTO_.customFieldPick, entity::setCustomFieldPick);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	public Actions<MyEntity3348InlinePickPickDTO> getActions() {
		return Actions.<MyEntity3348InlinePickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]
}
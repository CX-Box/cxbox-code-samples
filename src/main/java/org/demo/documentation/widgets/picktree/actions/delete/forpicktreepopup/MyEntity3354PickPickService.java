package org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3354PickPickService extends VersionAwareResponseService<MyEntity3354PickPickDTO, MyEntity3354Pick> {
	private final MyEntity3354PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3354PickPickMeta> meta = MyEntity3354PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3354PickPickDTO> doCreateEntity(MyEntity3354Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyEntity3354PickPickDTO> doUpdateEntity(MyEntity3354Pick entity, MyEntity3354PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3354PickPickDTO_.customField, entity::setCustomField);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:deleteEntity]
	@Override
	public ActionResultDTO<MyEntity3354PickPickDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3354PickPickDTO> contactDTOActionResultDTO;
		try {
			contactDTOActionResultDTO = super.deleteEntity(bc);
			repository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
		}
		return contactDTOActionResultDTO;
	}
	// --8<-- [end:deleteEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3354PickPickDTO> getActions() {
		return Actions.<MyEntity3354PickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]


}
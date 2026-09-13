package org.demo.documentation.widgets.picktree.actions.other.createwithparent;

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
public class MyEntity3350PickPickService extends VersionAwareResponseService<MyEntity3350PickPickDTO, MyEntity3350Pick> {

	private final MyEntity3350PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3350PickPickMeta> meta = MyEntity3350PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3350PickPickDTO> doCreateEntity(MyEntity3350Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3350PickPickDTO> doUpdateEntity(MyEntity3350Pick entity, MyEntity3350PickPickDTO data, BusinessComponent bc) {
		setIfChanged(data, MyEntity3350PickPickDTO_.customField, entity::setCustomField);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public ActionResultDTO<MyEntity3350PickPickDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3350PickPickDTO> contactDTOActionResultDTO;
		try {
			contactDTOActionResultDTO = super.deleteEntity(bc);
			repository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
		}
		return contactDTOActionResultDTO;
	}

	@Override
	public Actions<MyEntity3350PickPickDTO> getActions() {
		return Actions.<MyEntity3350PickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
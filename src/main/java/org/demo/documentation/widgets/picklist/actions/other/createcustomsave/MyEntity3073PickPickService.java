package org.demo.documentation.widgets.picklist.actions.other.createcustomsave;

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
public class MyEntity3073PickPickService extends VersionAwareResponseService<MyEntity3073PickPickDTO, MyEntity3073Pick> {
	private final MyEntity3073PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3073PickPickMeta> meta = MyEntity3073PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3073PickPickDTO> doCreateEntity(MyEntity3073Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3073PickPickDTO> doUpdateEntity(MyEntity3073Pick entity, MyEntity3073PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3073PickPickDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public ActionResultDTO<MyEntity3073PickPickDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3073PickPickDTO> contactDTOActionResultDTO;
		try {
			contactDTOActionResultDTO = super.deleteEntity(bc);
			repository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException(e).addPopup("You are trying to delete row, that is referenced from other place in system. Deletion is not available");
		}
		return contactDTOActionResultDTO;
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3073PickPickDTO> getActions() {
		return Actions.<MyEntity3073PickPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
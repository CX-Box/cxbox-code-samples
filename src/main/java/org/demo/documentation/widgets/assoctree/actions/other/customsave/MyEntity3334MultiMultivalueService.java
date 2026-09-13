package org.demo.documentation.widgets.assoctree.actions.other.customsave;

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
public class MyEntity3334MultiMultivalueService extends VersionAwareResponseService<MyEntity3334MultiMultivalueDTO, MyEntity3334Multi> {
	private final MyEntity3334MultiRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3334MultiMultivalueMeta> meta = MyEntity3334MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3334MultiMultivalueDTO> doCreateEntity(MyEntity3334Multi entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3334MultiMultivalueDTO> doUpdateEntity(MyEntity3334Multi entity, MyEntity3334MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		setIfChanged(data, MyEntity3334MultiMultivalueDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public ActionResultDTO<MyEntity3334MultiMultivalueDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3334MultiMultivalueDTO> contactDTOActionResultDTO;
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
	public Actions<MyEntity3334MultiMultivalueDTO> getActions() {
		return Actions.<MyEntity3334MultiMultivalueDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]
}
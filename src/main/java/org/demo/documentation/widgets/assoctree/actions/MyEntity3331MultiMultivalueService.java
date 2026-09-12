package org.demo.documentation.widgets.assoctree.actions;

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
public class MyEntity3331MultiMultivalueService extends VersionAwareResponseService<MyEntity3331MultiMultivalueDTO, MyEntity3331Multi> {
	private final MyEntity3331MultiRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3331MultiMultivalueMeta> meta = MyEntity3331MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3331MultiMultivalueDTO> doCreateEntity(MyEntity3331Multi entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3331MultiMultivalueDTO> doUpdateEntity(MyEntity3331Multi entity, MyEntity3331MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		setIfChanged(data, MyEntity3331MultiMultivalueDTO_.customField, entity::setCustomField);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public ActionResultDTO<MyEntity3331MultiMultivalueDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3331MultiMultivalueDTO> contactDTOActionResultDTO;
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
	public Actions<MyEntity3331MultiMultivalueDTO> getActions() {
		return Actions.<MyEntity3331MultiMultivalueDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]
}
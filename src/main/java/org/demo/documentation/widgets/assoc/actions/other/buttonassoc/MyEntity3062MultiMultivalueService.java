package org.demo.documentation.widgets.assoc.actions.other.buttonassoc;

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
public class MyEntity3062MultiMultivalueService extends VersionAwareResponseService<MyEntity3062MultiMultivalueDTO, MyEntity3062Multi> {
	private final MyEntity3062MultiRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3062MultiMultivalueMeta> meta = MyEntity3062MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3062MultiMultivalueDTO> doCreateEntity(MyEntity3062Multi entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3062MultiMultivalueDTO> doUpdateEntity(MyEntity3062Multi entity, MyEntity3062MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		setIfChanged(data, MyEntity3062MultiMultivalueDTO_.customField, entity::setCustomField);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public ActionResultDTO<MyEntity3062MultiMultivalueDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3062MultiMultivalueDTO> contactDTOActionResultDTO;
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
	public Actions<MyEntity3062MultiMultivalueDTO> getActions() {
		return Actions.<MyEntity3062MultiMultivalueDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
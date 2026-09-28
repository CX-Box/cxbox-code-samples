package org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assocreq;

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
public class MyEntity3340MultivalueService extends VersionAwareResponseService<MyEntity3340MultivalueDTO, MyEntity3340> {
	private final MyEntity3340MultiRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3340MultivalueMeta> meta = MyEntity3340MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3340MultivalueDTO> doCreateEntity(MyEntity3340 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3340MultivalueDTO> doUpdateEntity(MyEntity3340 entity, MyEntity3340MultivalueDTO data,
																		BusinessComponent bc) {
		setIfChanged(data, MyEntity3340MultivalueDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


	@Override
	public ActionResultDTO<MyEntity3340MultivalueDTO> deleteEntity(BusinessComponent bc) {
		ActionResultDTO<MyEntity3340MultivalueDTO> contactDTOActionResultDTO;
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
	public Actions<MyEntity3340MultivalueDTO> getActions() {
		return Actions.<MyEntity3340MultivalueDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]
}
package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forcardlist;

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
@Service
public class MyEntity3862CardService extends VersionAwareResponseService<MyEntity3862CardDTO, MyEntity3862Card> {

	private final MyEntity3862CardRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3862CardMeta> meta = MyEntity3862CardMeta.class;

	@Override
	protected CreateResult<MyEntity3862CardDTO> doCreateEntity(MyEntity3862Card entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3862CardDTO> doUpdateEntity(MyEntity3862Card entity, MyEntity3862CardDTO data, BusinessComponent bc) {
		setIfChanged(data, MyEntity3862CardDTO_.document, entity::setDocument);
		setIfChanged(data, MyEntity3862CardDTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyEntity3862CardDTO_.customField, entity::setCustomField);
		setIfChanged(data, MyEntity3862CardDTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3862CardDTO> getActions() {
		return Actions.<MyEntity3862CardDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}

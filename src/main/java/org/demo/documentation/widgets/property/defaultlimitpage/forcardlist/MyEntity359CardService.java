package org.demo.documentation.widgets.property.defaultlimitpage.forcardlist;

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
public class MyEntity359CardService extends VersionAwareResponseService<MyEntity359CardDTO, MyEntity359Card> {

	private final MyEntity359CardRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity359CardMeta> meta = MyEntity359CardMeta.class;

	@Override
	protected CreateResult<MyEntity359CardDTO> doCreateEntity(MyEntity359Card entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity359CardDTO> doUpdateEntity(MyEntity359Card entity, MyEntity359CardDTO data, BusinessComponent bc) {
		setIfChanged(data, MyEntity359CardDTO_.document, entity::setDocument);
		setIfChanged(data, MyEntity359CardDTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyEntity359CardDTO_.customField, entity::setCustomField);
		setIfChanged(data, MyEntity359CardDTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity359CardDTO> getActions() {
		return Actions.<MyEntity359CardDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}

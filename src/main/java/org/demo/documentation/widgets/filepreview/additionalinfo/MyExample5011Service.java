package org.demo.documentation.widgets.filepreview.additionalinfo;

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
public class MyExample5011Service extends VersionAwareResponseService<MyExample5011DTO, MyEntity5011> {

	private final MyEntity5011Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5011Meta> meta = MyExample5011Meta.class;

	@Override
	protected CreateResult<MyExample5011DTO> doCreateEntity(MyEntity5011 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5011DTO> doUpdateEntity(MyEntity5011 entity, MyExample5011DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5011DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5011DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5011DTO_.documentId, entity::setDocumentId);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5011DTO> getActions() {
		return Actions.<MyExample5011DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}

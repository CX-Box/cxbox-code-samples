package org.demo.documentation.widgets.filepreview.header;

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
public class MyExample5008Service extends VersionAwareResponseService<MyExample5008DTO, MyEntity5008> {

	private final MyEntity5008Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5008Meta> meta = MyExample5008Meta.class;

	@Override
	protected CreateResult<MyExample5008DTO> doCreateEntity(MyEntity5008 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5008DTO> doUpdateEntity(MyEntity5008 entity, MyExample5008DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5008DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5008DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5008DTO_.customFieldTitle, entity::setCustomFieldTitle);
		setIfChanged(data, MyExample5008DTO_.customFieldHint, entity::setCustomFieldHint);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5008DTO> getActions() {
		return Actions.<MyExample5008DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}

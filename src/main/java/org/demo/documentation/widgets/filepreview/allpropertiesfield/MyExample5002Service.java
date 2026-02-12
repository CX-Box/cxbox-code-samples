package org.demo.documentation.widgets.filepreview.allpropertiesfield;

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
public class MyExample5002Service extends VersionAwareResponseService<MyExample5002DTO, MyEntity5002> {

	private final MyEntity5002Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5002Meta> meta = MyExample5002Meta.class;

	@Override
	protected CreateResult<MyExample5002DTO> doCreateEntity(MyEntity5002 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5002DTO> doUpdateEntity(MyEntity5002 entity, MyExample5002DTO data, BusinessComponent bc) {

		setIfChanged(data, MyExample5002DTO_.customFieldId, entity::setCustomFieldId);
		if (data.isFieldChanged(MyExample5002DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5002DTO> getActions() {
		return Actions.<MyExample5002DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
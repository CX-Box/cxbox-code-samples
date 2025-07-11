package org.demo.documentation.fields.fileupload.required;

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
public class MyExample101Service extends VersionAwareResponseService<MyExample101DTO, MyEntity101> {

	private final MyEntity101Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample101Meta> meta = MyExample101Meta.class;

    @Override
	protected CreateResult<MyExample101DTO> doCreateEntity(MyEntity101 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample101DTO> doUpdateEntity(MyEntity101 entity, MyExample101DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample101DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample101DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample101DTO> getActions() {
		return Actions.<MyExample101DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.fileupload.basic;

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
public class MyExample94Service extends VersionAwareResponseService<MyExample94DTO, MyEntity94> {

	private final MyEntity94Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample94Meta> meta = MyExample94Meta.class;

    @Override
	protected CreateResult<MyExample94DTO> doCreateEntity(MyEntity94 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample94DTO> doUpdateEntity(MyEntity94 entity, MyExample94DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample94DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample94DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample94DTO> getActions() {
		return Actions.<MyExample94DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
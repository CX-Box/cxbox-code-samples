package org.demo.documentation.fields.fileupload.filtration;

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
public class MyExample99Service extends VersionAwareResponseService<MyExample99DTO, MyEntity99> {

	private final MyEntity99Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample99Meta> meta = MyExample99Meta.class;

    @Override
	protected CreateResult<MyExample99DTO> doCreateEntity(MyEntity99 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample99DTO> doUpdateEntity(MyEntity99 entity, MyExample99DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample99DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample99DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample99DTO> getActions() {
		return Actions.<MyExample99DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.fileupload.ro;

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
public class MyExample97Service extends VersionAwareResponseService<MyExample97DTO, MyEntity97> {

	private final MyEntity97Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample97Meta> meta = MyExample97Meta.class;

    @Override
	protected CreateResult<MyExample97DTO> doCreateEntity(MyEntity97 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample97DTO> doUpdateEntity(MyEntity97 entity, MyExample97DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample97DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample97DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample97DTO> getActions() {
		return Actions.<MyExample97DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
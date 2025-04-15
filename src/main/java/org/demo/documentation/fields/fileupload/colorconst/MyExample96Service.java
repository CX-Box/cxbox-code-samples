package org.demo.documentation.fields.fileupload.colorconst;

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
public class MyExample96Service extends VersionAwareResponseService<MyExample96DTO, MyEntity96> {

	private final MyEntity96Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample96Meta> meta = MyExample96Meta.class;

    @Override
	protected CreateResult<MyExample96DTO> doCreateEntity(MyEntity96 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample96DTO> doUpdateEntity(MyEntity96 entity, MyExample96DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample96DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample96DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample96DTO> getActions() {
		return Actions.<MyExample96DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
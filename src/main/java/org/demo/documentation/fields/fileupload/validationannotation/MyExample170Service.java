package org.demo.documentation.fields.fileupload.validationannotation;

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
public class MyExample170Service extends VersionAwareResponseService<MyExample170DTO, MyEntity170> {

	private final MyEntity170Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample170Meta> meta = MyExample170Meta.class;

    @Override
	protected CreateResult<MyExample170DTO> doCreateEntity(MyEntity170 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample170DTO> doUpdateEntity(MyEntity170 entity, MyExample170DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample170DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample170DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample170DTO> getActions() {
		return Actions.<MyExample170DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
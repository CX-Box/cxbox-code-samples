package org.demo.documentation.fields.dictionary.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample90Service extends VersionAwareResponseService<MyExample90DTO, MyEntity90> {

	private final MyEntity90Repository repository;

	public MyExample90Service(MyEntity90Repository repository) {
		super(MyExample90DTO.class, MyEntity90.class, null, MyExample90Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample90DTO> doCreateEntity(MyEntity90 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample90DTO> doUpdateEntity(MyEntity90 entity, MyExample90DTO data,
															 BusinessComponent bc) {
		setIfChanged(data, MyExample90DTO_.customFieldDictionaryCustomOrder, entity::setCustomFieldDictionaryCustomOrder);
		if (data.isFieldChanged(MyExample90DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample90DTO> getActions() {
		return Actions.<MyExample90DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
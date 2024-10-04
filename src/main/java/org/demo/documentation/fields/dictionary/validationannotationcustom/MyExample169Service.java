package org.demo.documentation.fields.dictionary.validationannotationcustom;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample169Service extends VersionAwareResponseService<MyExample169DTO, MyEntity169> {

	private final MyEntity169Repository repository;

	public MyExample169Service(MyEntity169Repository repository) {
		super(MyExample169DTO.class, MyEntity169.class, null, MyExample169Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample169DTO> doCreateEntity(MyEntity169 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample169DTO> doUpdateEntity(MyEntity169 entity, MyExample169DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample169DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample169DTO> getActions() {
		return Actions.<MyExample169DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
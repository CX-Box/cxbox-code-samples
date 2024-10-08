package org.demo.documentation.fields.checkbox.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_TRUE;


@Service
public class MyExample77Service extends VersionAwareResponseService<MyExample77DTO, MyEntity77> {

	private final MyEntity77Repository repository;

	public MyExample77Service(MyEntity77Repository repository) {
		super(MyExample77DTO.class, MyEntity77.class, null, MyExample77Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample77DTO> doCreateEntity(MyEntity77 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample77DTO> doUpdateEntity(MyEntity77 entity, MyExample77DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample77DTO_.customField)) {
			if (Boolean.FALSE.equals(data.getCustomField())) {
				throw new BusinessException().addPopup(ONLY_TRUE);
			}
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample77DTO> getActions() {
		return Actions.<MyExample77DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
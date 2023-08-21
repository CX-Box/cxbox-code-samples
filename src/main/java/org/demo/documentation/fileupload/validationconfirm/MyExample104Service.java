package org.demo.documentation.fileupload.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample104Service extends VersionAwareResponseService<MyExample104DTO, MyEntity104> {

	private final MyEntity104Repository repository;

	public MyExample104Service(MyEntity104Repository repository) {
		super(MyExample104DTO.class, MyEntity104.class, null, MyExample104Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample104DTO> doCreateEntity(MyEntity104 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample104DTO> doUpdateEntity(MyEntity104 entity, MyExample104DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample104DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample104DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample104DTO> getActions() {
		return Actions.<MyExample104DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}

}
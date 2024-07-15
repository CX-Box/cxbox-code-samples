package org.demo.documentation.fields.multifield.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample160Service extends VersionAwareResponseService<MyExample160DTO, MyEntity160> {

	private final MyEntity160Repository repository;

	public MyExample160Service(MyEntity160Repository repository) {
		super(MyExample160DTO.class, MyEntity160.class, null, MyExample160Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample160DTO> doCreateEntity(MyEntity160 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample160DTO> doUpdateEntity(MyEntity160 entity, MyExample160DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample160DTO_.customFieldAdditionalMulti)) {
			entity.setCustomFieldAdditionalMulti(data.getCustomFieldAdditionalMulti());
		}
		if (data.isFieldChanged(MyExample160DTO_.customFieldMulti)) {
			entity.setCustomFieldMulti(data.getCustomFieldMulti());
		}
		if (data.isFieldChanged(MyExample160DTO_.informationField)) {
			entity.setInformationField(data.getInformationField());
		}
		if (data.isFieldChanged(MyExample160DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample160DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyExample160DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample160DTO> getActions() {
		return Actions.<MyExample160DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}
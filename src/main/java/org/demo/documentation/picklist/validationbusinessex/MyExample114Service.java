package org.demo.documentation.picklist.validationbusinessex;

import javax.persistence.EntityManager;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample114Service extends VersionAwareResponseService<MyExample114DTO, MyEntity114> {

	private final MyEntity114Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample114Service(MyEntity114Repository repository) {
		super(MyExample114DTO.class, MyEntity114.class, null, MyExample114Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample114DTO> doCreateEntity(MyEntity114 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample114DTO> doUpdateEntity(MyEntity114 entity, MyExample114DTO data,
			BusinessComponent bc) {
		if (StringUtils.isNotEmpty(data.getCustomField())
				&& !String.valueOf(data.getCustomField()).matches("[A-Za-z]+")
		) {
			throw new BusinessException().addPopup("The field  can contain only letters.");
		}
		if (data.isFieldChanged(MyExample114DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity129.class, data.getCustomFieldId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample114DTO> getActions() {
		return Actions.<MyExample114DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.picktree.validationdynamic;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3294Service extends VersionAwareResponseService<MyExample3294DTO, MyEntity3294> {

	private final MyEntity3294Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3294Meta> meta = MyExample3294Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3294DTO> doCreateEntity(MyEntity3294 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3294DTO> doUpdateEntity(MyEntity3294 entity, MyExample3294DTO data,
															  BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample3294DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3294Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3294DTO> getActions() {
		return Actions.<MyExample3294DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample3294DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(MyExample3294DTO_.customField.getName(), "The field 'customField' can contain only letters.");
		}
		if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample3294DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (!entity.getFields().isEmpty()) {
			throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}
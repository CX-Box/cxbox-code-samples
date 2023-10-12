package org.demo.documentation.multivalue.basic;

import java.util.Objects;
import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample176Service extends VersionAwareResponseService<MyExample176DTO, MyEntity176> {

	private final MyEntity176Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample176Service(MyEntity176Repository repository) {
		super(MyExample176DTO.class, MyEntity176.class, null, MyExample176Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample176DTO> doCreateEntity(MyEntity176 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample176DTO> doUpdateEntity(MyEntity176 entity, MyExample176DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample176DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample176DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntityMultivalue177.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample176DTO> getActions() {
		return Actions.<MyExample176DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
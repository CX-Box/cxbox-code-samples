package org.demo.documentation.multivaluehover.validationbusinessex;

import java.util.Objects;
import java.util.stream.Collectors;
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
public class MyExample241Service extends VersionAwareResponseService<MyExample241DTO, MyEntity241> {

	private final MyEntity241Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample241Service(MyEntity241Repository repository) {
		super(MyExample241DTO.class, MyEntity241.class, null, MyExample241Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample241DTO> doCreateEntity(MyEntity241 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample241DTO> doUpdateEntity(MyEntity241 entity, MyExample241DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample241DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity242.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample241DTO> getActions() {
		return Actions.<MyExample241DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
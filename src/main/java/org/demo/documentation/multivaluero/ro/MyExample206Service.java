package org.demo.documentation.multivaluero.ro;

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
public class MyExample206Service extends VersionAwareResponseService<MyExample206DTO, MyEntity206> {

	private final MyEntity206Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample206Service(MyEntity206Repository repository) {
		super(MyExample206DTO.class, MyEntity206.class, null, MyExample206Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample206DTO> doCreateEntity(MyEntity206 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample206DTO> doUpdateEntity(MyEntity206 entity, MyExample206DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample206DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity207.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample206DTO> getActions() {
		return Actions.<MyExample206DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
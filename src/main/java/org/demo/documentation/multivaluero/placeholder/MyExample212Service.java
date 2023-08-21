package org.demo.documentation.multivaluero.placeholder;

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
public class MyExample212Service extends VersionAwareResponseService<MyExample212DTO, MyEntity212> {

	private final MyEntity212Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample212Service(MyEntity212Repository repository) {
		super(MyExample212DTO.class, MyEntity212.class, null, MyExample212Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample212DTO> doCreateEntity(MyEntity212 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample212DTO> doUpdateEntity(MyEntity212 entity, MyExample212DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample212DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity213.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample212DTO> getActions() {
		return Actions.<MyExample212DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
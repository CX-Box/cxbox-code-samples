package org.demo.documentation.multivaluero.drilldown;

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
public class MyExample208Service extends VersionAwareResponseService<MyExample208DTO, MyEntity208> {

	private final MyEntity208Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample208Service(MyEntity208Repository repository) {
		super(MyExample208DTO.class, MyEntity208.class, null, MyExample208Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample208DTO> doCreateEntity(MyEntity208 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample208DTO> doUpdateEntity(MyEntity208 entity, MyExample208DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample208DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity209.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample208DTO> getActions() {
		return Actions.<MyExample208DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
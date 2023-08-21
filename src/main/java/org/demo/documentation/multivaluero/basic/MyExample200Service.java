package org.demo.documentation.multivaluero.basic;

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
public class MyExample200Service extends VersionAwareResponseService<MyExample200DTO, MyEntity200> {

	private final MyEntity200Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample200Service(MyEntity200Repository repository) {
		super(MyExample200DTO.class, MyEntity200.class, null, MyExample200Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample200DTO> doCreateEntity(MyEntity200 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample200DTO> doUpdateEntity(MyEntity200 entity, MyExample200DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample200DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity201.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample200DTO> getActions() {
		return Actions.<MyExample200DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
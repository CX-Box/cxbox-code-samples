package org.demo.documentation.multivaluero.sorting;

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
public class MyExample216Service extends VersionAwareResponseService<MyExample216DTO, MyEntity216> {

	private final MyEntity216Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample216Service(MyEntity216Repository repository) {
		super(MyExample216DTO.class, MyEntity216.class, null, MyExample216Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample216DTO> doCreateEntity(MyEntity216 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample216DTO> doUpdateEntity(MyEntity216 entity, MyExample216DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample216DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity217.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample216DTO> getActions() {
		return Actions.<MyExample216DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
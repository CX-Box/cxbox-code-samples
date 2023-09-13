package org.demo.documentation.multivalue.filtration;

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
public class MyExample184Service extends VersionAwareResponseService<MyExample184DTO, MyEntity184> {

	private final MyEntity184Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample184Service(MyEntity184Repository repository) {
		super(MyExample184DTO.class, MyEntity184.class, null, MyExample184Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample184DTO> doCreateEntity(MyEntity184 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample184DTO> doUpdateEntity(MyEntity184 entity, MyExample184DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample184DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity185.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample184DTO> getActions() {
		return Actions.<MyExample184DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
package org.demo.documentation.multivalue.colorconst;

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
public class MyExample178Service extends VersionAwareResponseService<MyExample178DTO, MyEntity178> {

	private final MyEntity178Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample178Service(MyEntity178Repository repository) {
		super(MyExample178DTO.class, MyEntity178.class, null, MyExample178Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample178DTO> doCreateEntity(MyEntity178 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample178DTO> doUpdateEntity(MyEntity178 entity, MyExample178DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample178DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity179.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample178DTO> getActions() {
		return Actions.<MyExample178DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
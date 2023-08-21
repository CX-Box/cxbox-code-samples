package org.demo.documentation.multivaluehover.basic;

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
public class MyExample224Service extends VersionAwareResponseService<MyExample224DTO, MyEntity224> {

	private final MyEntity224Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample224Service(MyEntity224Repository repository) {
		super(MyExample224DTO.class, MyEntity224.class, null, MyExample224Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample224DTO> doCreateEntity(MyEntity224 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample224DTO> doUpdateEntity(MyEntity224 entity, MyExample224DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample224DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity259.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample224DTO> getActions() {
		return Actions.<MyExample224DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
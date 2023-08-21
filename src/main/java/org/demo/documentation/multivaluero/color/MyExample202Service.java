package org.demo.documentation.multivaluero.color;

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
public class MyExample202Service extends VersionAwareResponseService<MyExample202DTO, MyEntity202> {

	private final MyEntity202Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample202Service(MyEntity202Repository repository) {
		super(MyExample202DTO.class, MyEntity202.class, null, MyExample202Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample202DTO> doCreateEntity(MyEntity202 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample202DTO> doUpdateEntity(MyEntity202 entity, MyExample202DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample202DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity203.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample202DTO> getActions() {
		return Actions.<MyExample202DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
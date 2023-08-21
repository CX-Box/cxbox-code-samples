package org.demo.documentation.multivalue.required;

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
public class MyExample188Service extends VersionAwareResponseService<MyExample188DTO, MyEntity188> {

	private final MyEntity188Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample188Service(MyEntity188Repository repository) {
		super(MyExample188DTO.class, MyEntity188.class, null, MyExample188Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample188DTO> doCreateEntity(MyEntity188 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample188DTO> doUpdateEntity(MyEntity188 entity, MyExample188DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample188DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity189.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample188DTO> getActions() {
		return Actions.<MyExample188DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
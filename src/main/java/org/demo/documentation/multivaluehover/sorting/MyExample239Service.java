package org.demo.documentation.multivaluehover.sorting;

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
public class MyExample239Service extends VersionAwareResponseService<MyExample239DTO, MyEntity239> {

	private final MyEntity239Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample239Service(MyEntity239Repository repository) {
		super(MyExample239DTO.class, MyEntity239.class, null, MyExample239Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample239DTO> doCreateEntity(MyEntity239 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample239DTO> doUpdateEntity(MyEntity239 entity, MyExample239DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample239DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity240.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample239DTO> getActions() {
		return Actions.<MyExample239DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
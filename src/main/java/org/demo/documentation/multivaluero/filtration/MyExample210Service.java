package org.demo.documentation.multivaluero.filtration;

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
public class MyExample210Service extends VersionAwareResponseService<MyExample210DTO, MyEntity210> {

	private final MyEntity210Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample210Service(MyEntity210Repository repository) {
		super(MyExample210DTO.class, MyEntity210.class, null, MyExample210Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample210DTO> doCreateEntity(MyEntity210 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample210DTO> doUpdateEntity(MyEntity210 entity, MyExample210DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample210DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity211.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample210DTO> getActions() {
		return Actions.<MyExample210DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
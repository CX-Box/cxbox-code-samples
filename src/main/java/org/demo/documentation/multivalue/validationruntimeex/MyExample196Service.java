package org.demo.documentation.multivalue.validationruntimeex;

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
public class MyExample196Service extends VersionAwareResponseService<MyExample196DTO, MyEntity196> {

	private final MyEntity196Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample196Service(MyEntity196Repository repository) {
		super(MyExample196DTO.class, MyEntity196.class, null, MyExample196Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample196DTO> doCreateEntity(MyEntity196 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample196DTO> doUpdateEntity(MyEntity196 entity, MyExample196DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample196DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity197.class, e))
					.collect(Collectors.toList()));
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample196DTO> getActions() {
		return Actions.<MyExample196DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
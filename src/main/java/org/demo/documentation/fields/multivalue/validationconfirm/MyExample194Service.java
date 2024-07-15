package org.demo.documentation.fields.multivalue.validationconfirm;

import java.util.Objects;
import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample194Service extends VersionAwareResponseService<MyExample194DTO, MyEntity194> {

	private final MyEntity194Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample194Service(MyEntity194Repository repository) {
		super(MyExample194DTO.class, MyEntity194.class, null, MyExample194Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample194DTO> doCreateEntity(MyEntity194 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample194DTO> doUpdateEntity(MyEntity194 entity, MyExample194DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample194DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity195.class, e))
					.toList());

		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample194DTO> getActions() {
		return Actions.<MyExample194DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value ?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}
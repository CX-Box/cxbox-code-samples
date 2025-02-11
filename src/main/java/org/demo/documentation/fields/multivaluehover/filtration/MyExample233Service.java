package org.demo.documentation.fields.multivaluehover.filtration;

import java.util.Objects;
import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample233Service extends VersionAwareResponseService<MyExample233DTO, MyEntity233> {

	private final MyEntity233Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample233Service(MyEntity233Repository repository) {
		super(MyExample233DTO.class, MyEntity233.class, null, MyExample233Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample233DTO> doCreateEntity(MyEntity233 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample233DTO> doUpdateEntity(MyEntity233 entity, MyExample233DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample233DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity234.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample233DTO> getActions() {
		return Actions.<MyExample233DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
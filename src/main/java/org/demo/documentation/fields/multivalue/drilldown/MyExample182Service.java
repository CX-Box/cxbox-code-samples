package org.demo.documentation.fields.multivalue.drilldown;

import java.util.Objects;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample182Service extends VersionAwareResponseService<MyExample182DTO, MyEntity182> {

	private final MyEntity182Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample182Meta> meta = MyExample182Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample182DTO> doCreateEntity(MyEntity182 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample182DTO> doUpdateEntity(MyEntity182 entity, MyExample182DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample182DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity183.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample182DTO> getActions() {
		return Actions.<MyExample182DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
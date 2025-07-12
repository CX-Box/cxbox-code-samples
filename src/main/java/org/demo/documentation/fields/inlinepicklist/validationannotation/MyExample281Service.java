package org.demo.documentation.fields.inlinepicklist.validationannotation;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample281Service extends VersionAwareResponseService<MyExample281DTO, MyEntity281> {

	private final MyEntity281Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample281Meta> meta = MyExample281Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample281DTO> doCreateEntity(MyEntity281 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample281DTO> doUpdateEntity(MyEntity281 entity, MyExample281DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample281DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity280.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample281DTO> getActions() {
		return Actions.<MyExample281DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
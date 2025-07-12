package org.demo.documentation.fields.inlinepicklist.placeholder;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.inlinepicklist.placeholder.picklist.MyEntity145;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample144Service extends VersionAwareResponseService<MyExample144DTO, MyEntity144> {

	private final MyEntity144Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample144Meta> meta = MyExample144Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample144DTO> doCreateEntity(MyEntity144 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample144DTO> doUpdateEntity(MyEntity144 entity, MyExample144DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample144DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity145.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample144DTO> getActions() {
		return Actions.<MyExample144DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
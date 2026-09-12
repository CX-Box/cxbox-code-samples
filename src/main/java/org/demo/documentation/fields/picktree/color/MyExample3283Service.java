package org.demo.documentation.fields.picktree.color;

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
public class MyExample3283Service extends VersionAwareResponseService<MyExample3283DTO, MyEntity3283> {

	private final MyEntity3283Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3283Meta> meta = MyExample3283Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3283DTO> doCreateEntity(MyEntity3283 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3283DTO> doUpdateEntity(MyEntity3283 entity, MyExample3283DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3283DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3283Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3283DTO> getActions() {
		return Actions.<MyExample3283DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
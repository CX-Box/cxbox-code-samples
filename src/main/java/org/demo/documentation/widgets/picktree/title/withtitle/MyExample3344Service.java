package org.demo.documentation.widgets.picktree.title.withtitle;

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
public class MyExample3344Service extends VersionAwareResponseService<MyExample3344DTO, MyEntity3344> {

	private final MyEntity3344Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3344Meta> meta = MyExample3344Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3344DTO> doCreateEntity(MyEntity3344 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3344DTO> doUpdateEntity(MyEntity3344 entity, MyExample3344DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3344DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3344Pick.class, data.getCustomFieldId())
					: null);
		}
		if (data.isFieldChanged(MyExample3344DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3344Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3344DTO> getActions() {
		return Actions.<MyExample3344DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

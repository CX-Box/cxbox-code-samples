package org.demo.documentation.widgets.picktree.actions.other.createwithparent;

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
public class MyExample3350Service extends VersionAwareResponseService<MyExample3350DTO, MyEntity3350> {

	private final MyEntity3350Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3350Meta> meta = MyExample3350Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3350DTO> doCreateEntity(MyEntity3350 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3350DTO> doUpdateEntity(MyEntity3350 entity, MyExample3350DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3350DTO_.customFieldRequred, entity::setCustomFieldRequred);
		setIfChanged(data, MyExample3350DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3350DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3350Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3350DTO> getActions() {
		return Actions.<MyExample3350DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

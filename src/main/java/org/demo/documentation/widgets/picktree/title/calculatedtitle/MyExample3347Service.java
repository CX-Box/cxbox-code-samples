package org.demo.documentation.widgets.picktree.title.calculatedtitle;

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
public class MyExample3347Service extends VersionAwareResponseService<MyExample3347DTO, MyEntity3347> {

	private final MyEntity3347Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3347Meta> meta = MyExample3347Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3347DTO> doCreateEntity(MyEntity3347 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3347DTO> doUpdateEntity(MyEntity3347 entity, MyExample3347DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3347DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3347Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3347DTO> getActions() {
		return Actions.<MyExample3347DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

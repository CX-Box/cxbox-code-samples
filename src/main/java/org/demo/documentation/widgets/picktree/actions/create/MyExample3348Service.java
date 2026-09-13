package org.demo.documentation.widgets.picktree.actions.create;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.actions.create.inlinepicktree.MyEntity3348InlinePick;
import org.demo.documentation.widgets.picktree.actions.create.picktree.MyEntity3348Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3348Service extends VersionAwareResponseService<MyExample3348DTO, MyEntity3348> {

	private final MyEntity3348Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3348Meta> meta = MyExample3348Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3348DTO> doCreateEntity(MyEntity3348 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3348DTO> doUpdateEntity(MyEntity3348 entity, MyExample3348DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3348DTO_.customFieldInlinePicktreeId)) {
			entity.setCustomFieldInlinePicktreeEntity(data.getCustomFieldInlinePicktreeId() != null
					? entityManager.getReference(MyEntity3348InlinePick.class, data.getCustomFieldInlinePicktreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3348DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3348Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3348DTO> getActions() {
		return Actions.<MyExample3348DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}

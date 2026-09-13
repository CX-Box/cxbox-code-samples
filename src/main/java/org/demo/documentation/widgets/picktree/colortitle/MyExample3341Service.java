package org.demo.documentation.widgets.picktree.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3341Service extends VersionAwareResponseService<MyExample3341DTO, MyEntity3341> {

	private final MyEntity3341Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3341Meta> meta = MyExample3341Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3341DTO> doCreateEntity(MyEntity3341 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3341DTO> doUpdateEntity(MyEntity3341 entity, MyExample3341DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3341DTO_.customFieldPicktreeColorConstId)) {
			entity.setCustomFieldPicktreeColorConstEntity(data.getCustomFieldPicktreeColorConstId() != null
					? entityManager.getReference(MyEntity3342Pick.class, data.getCustomFieldPicktreeColorConstId())
					: null);
		}
		if (data.isFieldChanged(MyExample3341DTO_.customFieldPicktreeId)) {
			entity.setCustomFieldPicktreeEntity(data.getCustomFieldPicktreeId() != null
					? entityManager.getReference(MyEntity3342.class, data.getCustomFieldPicktreeId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3341DTO> getActions() {
		return Actions.<MyExample3341DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}

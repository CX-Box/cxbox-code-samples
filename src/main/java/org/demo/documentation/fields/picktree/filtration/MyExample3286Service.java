package org.demo.documentation.fields.picktree.filtration;

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
public class MyExample3286Service extends VersionAwareResponseService<MyExample3286DTO, MyEntity3286> {

	private final MyEntity3286Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3286Meta> meta = MyExample3286Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3286DTO> doCreateEntity(MyEntity3286 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3286DTO> doUpdateEntity(MyEntity3286 entity, MyExample3286DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3286DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3286Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3286DTO> getActions() {
		return Actions.<MyExample3286DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
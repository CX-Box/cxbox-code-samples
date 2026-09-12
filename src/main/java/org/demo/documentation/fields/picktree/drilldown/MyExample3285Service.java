package org.demo.documentation.fields.picktree.drilldown;

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
public class MyExample3285Service extends VersionAwareResponseService<MyExample3285DTO, MyEntity3285> {

	private final MyEntity3285Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3285Meta> meta = MyExample3285Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3285DTO> doCreateEntity(MyEntity3285 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3285DTO> doUpdateEntity(MyEntity3285 entity, MyExample3285DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3285DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3285Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3285DTO> getActions() {
		return Actions.<MyExample3285DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
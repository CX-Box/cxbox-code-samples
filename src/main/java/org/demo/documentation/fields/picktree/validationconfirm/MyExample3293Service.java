package org.demo.documentation.fields.picktree.validationconfirm;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3293Service extends VersionAwareResponseService<MyExample3293DTO, MyEntity3293> {

	private final MyEntity3293Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3293Meta> meta = MyExample3293Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3293DTO> doCreateEntity(MyEntity3293 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3293DTO> doUpdateEntity(MyEntity3293 entity, MyExample3293DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3293DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3293Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3293DTO> getActions() {
		return Actions.<MyExample3293DTO>builder()
				.action(act -> act
						.action("save", "save")
						.withPreAction(PreAction.confirm(cf -> cf
								.text("You want to save the value?")
						)))
				.build();
	}
	// --8<-- [end:getActions]

}
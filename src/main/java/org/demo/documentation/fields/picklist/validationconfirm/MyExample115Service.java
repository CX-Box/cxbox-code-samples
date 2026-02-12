package org.demo.documentation.fields.picklist.validationconfirm;

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
public class MyExample115Service extends VersionAwareResponseService<MyExample115DTO, MyEntity115> {

	private final MyEntity115Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample115Meta> meta = MyExample115Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample115DTO> doCreateEntity(MyEntity115 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample115DTO> doUpdateEntity(MyEntity115 entity, MyExample115DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample115DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity130.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample115DTO> getActions() {
		return Actions.<MyExample115DTO>builder()
				.action(act -> act
						.action("save", "save")
						.withPreAction(PreAction.confirm(cf -> cf
								.text("You want to save the value?")
						)))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.inlinepicklist.validationconfirm;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample152Service extends VersionAwareResponseService<MyExample152DTO, MyEntity152> {

	private final MyEntity152Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample152Meta> meta = MyExample152Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample152DTO> doCreateEntity(MyEntity152 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample152DTO> doUpdateEntity(MyEntity152 entity, MyExample152DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample152DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity153.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample152DTO> getActions() {
		return Actions.<MyExample152DTO>builder()
				.action(act -> act
						.action("save", "save")
						.withPreAction(PreAction.confirm(cf -> cf
								.text("You want to save the value?")
						)))
				.build();
	}
	// --8<-- [end:getActions]

}
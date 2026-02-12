package org.demo.documentation.widgets.formpopup.base.onefield;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.MyEntity3400InlinePicklist;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.fa.MyEntity3400InlinePicklistFA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3400Service extends VersionAwareResponseService<MyExample3400DTO, MyEntity3400> {

	private final MyEntity3400Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3400Meta> meta = MyExample3400Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3400DTO> doCreateEntity(MyEntity3400 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3400DTO> doUpdateEntity(MyEntity3400 entity, MyExample3400DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3400DTO_.customFieldInlinePicklistFAId)) {
			entity.setCustomFieldInlinePicklistFAEntity(data.getCustomFieldInlinePicklistFAId() != null
					? entityManager.getReference(MyEntity3400InlinePicklistFA.class, data.getCustomFieldInlinePicklistFAId())
					: null);
		}
		setIfChanged(data, MyExample3400DTO_.customFieldRequired2, entity::setCustomFieldRequired2);
		setIfChanged(data, MyExample3400DTO_.customFieldRequired, entity::setCustomFieldRequired);
		if (data.isFieldChanged(MyExample3400DTO_.customFieldInlinePicklistId)) {
			entity.setCustomFieldInlinePicklistEntity(data.getCustomFieldInlinePicklistId() != null
					? entityManager.getReference(MyEntity3400InlinePicklist.class, data.getCustomFieldInlinePicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3400DTO_.customField2)) {
			entity.setCustomField2(data.getCustomField2());
		}
		if (data.isFieldChanged(MyExample3400DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3400DTO> getActions() {
		return Actions.<MyExample3400DTO>builder()
				.action(act -> act
						.scope(ActionScope.RECORD)
						.withAutoSaveBefore()
						.action("save-send", "Save and send on approval")
						.withPreAction(PreAction.confirmWithWidget(
								"MyExample3400Formpopup", cfw -> cfw
										.title("Approve?")
										.yesText("Approve and Save")
										.noText("Cancel")))
						.invoker((bc, dto) -> new ActionResultDTO<MyExample3400DTO>()))
				.create(crt -> crt.text("Create"))
				.build();
	}

	// --8<-- [end:getActions]
}
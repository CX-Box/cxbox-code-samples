package org.demo.documentation.widgets.cardlist.actions.newview;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5309Service extends VersionAwareResponseService<MyExample5309DTO, MyEntity5309> {

	private final MyEntity5309Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5309Meta> meta = MyExample5309Meta.class;

	// --8<-- [start:doCreateEntity]
	@Override
	protected CreateResult<MyExample5309DTO> doCreateEntity(MyEntity5309 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						"/screen/myexample5309/view/myexample5309form/"
								+ CxboxMyExample5309Controller.myexample5309 + "/"
								+ entity.getId()));
	}
	// --8<-- [end:doCreateEntity]

	@Override
	protected ActionResultDTO<MyExample5309DTO> doUpdateEntity(MyEntity5309 entity, MyExample5309DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5309DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5309DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5309DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5309DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5309DTO> getActions() {
		return Actions.<MyExample5309DTO>builder()
				.create(crt -> crt.text("Add"))
				.action(act -> act
						.action("edit", "Edit")
						.withIcon(MyExample5309ActionIcon.EDIT, true)
						.withoutAutoSaveBefore()
						.invoker((bc, data) -> new ActionResultDTO<MyExample5309DTO>()
								.setAction(PostAction.drillDown(
										DrillDownType.INNER,
										"/screen/myexample5309/view/myexample5309form/"
												+ CxboxMyExample5309Controller.myexample5309 + "/"
												+ bc.getId()
								)))
				)
				.action(act -> act
						.action("finish", "Save and Close")
						.invoker((bc, dto) -> new ActionResultDTO<MyExample5309DTO>()
								.setAction(PostAction.drillDown(
										DrillDownType.INNER,
										"/screen/myexample5309/view/myexample5309list"
								)))
				)
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}

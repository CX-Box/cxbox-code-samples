package org.demo.documentation.widgets.tree.actions.create.newview;

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
public class MyExample3266Service extends VersionAwareResponseService<MyExample3266DTO, MyEntity3266> {

	private final MyEntity3266Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3266Meta> meta = MyExample3266Meta.class;

	// --8<-- [start:doCreateEntity]
	@Override
	protected CreateResult<MyExample3266DTO> doCreateEntity(MyEntity3266 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						"/screen/myexample3266/view/myexample3266form/"
								+ CxboxMyExample3266Controller.myexample3266 + "/"
								+ entity.getId()));
	}
	// --8<-- [end:doCreateEntity]

	@Override
	protected ActionResultDTO<MyExample3266DTO> doUpdateEntity(MyEntity3266 entity, MyExample3266DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3266DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3266DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3266DTO> getActions() {
		return Actions.<MyExample3266DTO>builder()
				.create(crt -> crt.text("Add"))
				.action(act -> act
						.action("finish", "Save and Close")
						.invoker((bc, dto) -> {
							MyEntity3266 myEntity = repository.getReferenceById(bc.getIdAsLong());
							repository.save(myEntity);
							return new ActionResultDTO<MyExample3266DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample3266/view/myexample3266list"
									));
						})
				)
				.build();
	}
	// --8<-- [end:getActions]

}

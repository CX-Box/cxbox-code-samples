package org.demo.documentation.widgets.calendarlist.actions.create.newview;

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
public class MyExample5062Service extends VersionAwareResponseService<MyExample5062DTO, MyEntity5062> {

	private final MyEntity5062Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5062Meta> meta = MyExample5062Meta.class;

	// --8<-- [start:doCreateEntity]
	@Override
	protected CreateResult<MyExample5062DTO> doCreateEntity(MyEntity5062 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						"/screen/myexample5062/view/myexample5062form/"
								+ PlatformMyExample5062Controller.myexample5062 + "/"
								+ entity.getId()));
	}
	// --8<-- [end:doCreateEntity]

	@Override
	protected ActionResultDTO<MyExample5062DTO> doUpdateEntity(MyEntity5062 entity, MyExample5062DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5062DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5062DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5062DTO_.endDateTime, entity::setEndDateTime);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5062DTO> getActions() {
		return Actions.<MyExample5062DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.action("finish", "Save and Close")
						.invoker((bc, dto) -> {
							MyEntity5062 myEntity = repository.getReferenceById(bc.getIdAsLong());
							repository.save(myEntity);
							return new ActionResultDTO<MyExample5062DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample5062/view/myexample5062list"
									));
						})
				)
				.build();
	}
	// --8<-- [end:getActions]

}

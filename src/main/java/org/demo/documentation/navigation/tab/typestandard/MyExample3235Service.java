package org.demo.documentation.navigation.tab.typestandard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3235Service extends VersionAwareResponseService<MyExample3235DTO, MyEntity3235> {

	private final MyEntity3235Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3235Meta> meta = MyExample3235Meta.class;

	@Override
	protected CreateResult<MyExample3235DTO> doCreateEntity(MyEntity3235 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3235DTO> doUpdateEntity(MyEntity3235 entity, MyExample3235DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3235DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3235DTO> getActions() {
		return Actions.<MyExample3235DTO>builder()
				.action(act -> act)
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.scope(ActionScope.RECORD)
						.action("gotolistsecondlevel", "Go to view hidden 2 level")
						.invoker((bc, dto) -> {
							return new ActionResultDTO<MyExample3235DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample32359/view/myexample3235secondleveltabhidden"
									));
						})
				)
				.action(act -> act
						.scope(ActionScope.RECORD)
						.action("gotolistthirdlevel", "Go to view hidden 3 level")
						.invoker((bc, dto) -> {
							return new ActionResultDTO<MyExample3235DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample32359/view/myexample3235thirdleveltabhidden"
									));
						})
				)
				.action(act -> act
						.scope(ActionScope.RECORD)
						.action("gotolistfourthlevel", "Go to view hidden 4 level")
						.invoker((bc, dto) -> {
							return new ActionResultDTO<MyExample3235DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample32359/view/myexample3235fourthleveltabhidden"
									));
						})
				)
				.build();
	}
	// --8<-- [end:getActions]
}

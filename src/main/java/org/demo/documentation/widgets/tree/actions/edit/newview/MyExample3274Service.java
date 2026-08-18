package org.demo.documentation.widgets.tree.actions.edit.newview;

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

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3274Service extends VersionAwareResponseService<MyExample3274DTO, MyEntity3274> {

	private final MyEntity3274Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3274Meta> meta = MyExample3274Meta.class;

	@Override
	protected CreateResult<MyExample3274DTO> doCreateEntity(MyEntity3274 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3274DTO> doUpdateEntity(MyEntity3274 entity, MyExample3274DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3274DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3274DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3274DTO> getActions() {
		return Actions.<MyExample3274DTO>builder()
				.action(act -> act
						.action("finish", "Save and Close")
						.invoker((bc, dto) -> {
							MyEntity3274 myEntity = repository.getReferenceById(bc.getIdAsLong());
							repository.save(myEntity);
							return new ActionResultDTO<MyExample3274DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample3274/view/myexample3274list"
									));
						})
				)
				.addGroup(
						"actions",
						"Actions",
						0,
						Actions.<MyExample3274DTO>builder()
								.action(act -> act
										.action("edit", "Edit")
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> {
											return new ActionResultDTO<MyExample3274DTO>()
													.setAction(PostAction.drillDown(
															DrillDownType.INNER,
															"/screen/myexample3274/view/myexample3274form/"
																	+ CxboxMyExample3274Controller.myexample3274 + "/"
																	+ bc.getId()
													));
										})).build()
				)
				.build();
	}


}


package org.demo.documentation.widgets.list.actions.edit.newview;

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
public class MyExample3075Service extends VersionAwareResponseService<MyExample3075DTO, MyEntity3075> {

	private final MyEntity3075Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3075Meta> meta = MyExample3075Meta.class;

	@Override
	protected CreateResult<MyExample3075DTO> doCreateEntity(MyEntity3075 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3075DTO> doUpdateEntity(MyEntity3075 entity, MyExample3075DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3075DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3075DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3075DTO> getActions() {
		return Actions.<MyExample3075DTO>builder()
				.action(act -> act
						.action("finish", "Save and Close")
						.invoker((bc, dto) -> {
							MyEntity3075 myEntity = repository.getReferenceById(bc.getIdAsLong());
							repository.save(myEntity);
							return new ActionResultDTO<MyExample3075DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample3075/view/myexample3075list"
									));
						})
				)
				.addGroup(
						"actions",
						"Actions",
						0,
						Actions.<MyExample3075DTO>builder()
								.action(act -> act
										.action("edit", "Edit")
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> {
											return new ActionResultDTO<MyExample3075DTO>()
													.setAction(PostAction.drillDown(
															DrillDownType.INNER,
															"/screen/myexample3075/view/myexample3075form/"
																	+ CxboxMyExample3075Controller.myexample3075 + "/"
																	+ bc.getId()
													));
										})).build()
				)
				.build();
	}


}


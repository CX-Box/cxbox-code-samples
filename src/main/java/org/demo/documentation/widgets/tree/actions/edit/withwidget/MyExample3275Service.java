package org.demo.documentation.widgets.tree.actions.edit.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3275Service extends VersionAwareResponseService<MyExample3275DTO, MyEntity3275> {

	private final MyEntity3275Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3275Meta> meta = MyExample3275Meta.class;

	@Override
	protected CreateResult<MyExample3275DTO> doCreateEntity(MyEntity3275 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3275DTO> doUpdateEntity(MyEntity3275 entity, MyExample3275DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3275DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3275DTO_.parentId, entity::setParentId);

		setIfChanged(data, MyExample3275DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3275DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		MyExample3275DTO dto = entityToDto(bc, repository.save(entity));
		dto.setIsLeaf(!repository.existsByParentId(String.valueOf(entity.getId())));

		return new ActionResultDTO<>(dto);
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3275DTO> getActions() {
		return Actions.<MyExample3275DTO>builder()
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("edit", "Edit"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}


}


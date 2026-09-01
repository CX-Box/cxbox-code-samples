package org.demo.documentation.widgets.tree.actions.edit.basic;

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
public class MyExample3273Service extends VersionAwareResponseService<MyExample3273DTO, MyEntity3273> {

	private final MyEntity3273Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3273Meta> meta = MyExample3273Meta.class;

	@Override
	protected CreateResult<MyExample3273DTO> doCreateEntity(MyEntity3273 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3273DTO> doUpdateEntity(MyEntity3273 entity, MyExample3273DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3273DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3273DTO_.parentId, entity::setParentId);
		setIfChanged(data, MyExample3273DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3273DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		MyExample3273DTO dto = entityToDto(bc, repository.save(entity));
		dto.setIsLeaf(!repository.existsByParentId(String.valueOf(entity.getId())));

		return new ActionResultDTO<>(dto);
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3273DTO> getActions() {
		return Actions.<MyExample3273DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
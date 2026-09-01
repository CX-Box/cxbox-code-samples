package org.demo.documentation.widgets.tree.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3276Service extends VersionAwareResponseService<MyExample3276DTO, MyEntity3276> {

	private final MyEntity3276Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3276Meta> meta = MyExample3276Meta.class;

	@Override
	protected CreateResult<MyExample3276DTO> doCreateEntity(MyEntity3276 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3276DTO> doUpdateEntity(MyEntity3276 entity, MyExample3276DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3276DTO_.parentTreeId, entity::setParentTreeId);
		setIfChanged(data, MyExample3276DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3276DTO_.parentId, entity::setParentId);
		setIfChanged(data, MyExample3276DTO_.isLeaf, entity::setIsLeaf);
		setIfChanged(data, MyExample3276DTO_.customFieldNumber, entity::setCustomFieldNumber);
		if (data.isFieldChanged(MyExample3276DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3276DTO> getActions() {
		return Actions.<MyExample3276DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
package org.demo.documentation.widgets.tree.actions.create.basic;

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
public class MyExample3265Service extends VersionAwareResponseService<MyExample3265DTO, MyEntity3265> {

	private final MyEntity3265Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3265Meta> meta = MyExample3265Meta.class;

	@Override
	protected CreateResult<MyExample3265DTO> doCreateEntity(MyEntity3265 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3265DTO> doUpdateEntity(MyEntity3265 entity, MyExample3265DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3265DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3265DTO_.parentId, entity::setParentId);

		setIfChanged(data, MyExample3265DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3265DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		MyExample3265DTO dto = entityToDto(bc, repository.save(entity));
		dto.setIsLeaf(!repository.existsByParentId(String.valueOf(entity.getId())));

		return new ActionResultDTO<>(dto);
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3265DTO> getActions() {
		return Actions.<MyExample3265DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
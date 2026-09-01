package org.demo.documentation.widgets.tree.actions.create.withwidget;

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
public class MyExample3279Service extends VersionAwareResponseService<MyExample3279DTO, MyEntity3279> {

	private final MyEntity3279Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3279Meta> meta = MyExample3279Meta.class;

	@Override
	protected CreateResult<MyExample3279DTO> doCreateEntity(MyEntity3279 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3279DTO> doUpdateEntity(MyEntity3279 entity, MyExample3279DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3279DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3279DTO_.parentId, entity::setParentId);
		setIfChanged(data, MyExample3279DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3279DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		MyExample3279DTO dto = entityToDto(bc, repository.save(entity));
		dto.setIsLeaf(!repository.existsByParentId(String.valueOf(entity.getId())));

		return new ActionResultDTO<>(dto);
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3279DTO> getActions() {
		return Actions.<MyExample3279DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}


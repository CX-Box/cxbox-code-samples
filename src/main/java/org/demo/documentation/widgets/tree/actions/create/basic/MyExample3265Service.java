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
		setIfChanged(data, MyExample3265DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3265DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3265DTO> getActions() {
		return Actions.<MyExample3265DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]

}
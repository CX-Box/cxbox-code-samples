package org.demo.documentation.fields.richtext.height;

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
public class MyExample436Service extends VersionAwareResponseService<MyExample436DTO, MyEntity436> {

	private final MyEntity436Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample436Meta> meta = MyExample436Meta.class;

	@Override
	protected CreateResult<MyExample436DTO> doCreateEntity(MyEntity436 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample436DTO> doUpdateEntity(MyEntity436 entity, MyExample436DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample436DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample436DTO> getActions() {
		return Actions.<MyExample436DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}

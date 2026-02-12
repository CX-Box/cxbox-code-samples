package org.demo.documentation.fields.text.basic;

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
public class MyExample40Service extends VersionAwareResponseService<MyExample40DTO, MyEntity40> {

	private final MyEntity40Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample40Meta> meta = MyExample40Meta.class;

	@Override
	protected CreateResult<MyExample40DTO> doCreateEntity(MyEntity40 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample40DTO> doUpdateEntity(MyEntity40 entity, MyExample40DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(org.demo.documentation.fields.text.basic.MyExample40DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample40DTO> getActions() {
		return Actions.<MyExample40DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.checkbox.drilldown;

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
public class MyExample55Service extends VersionAwareResponseService<MyExample55DTO, MyEntity55> {

	private final MyEntity55Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample55Meta> meta = MyExample55Meta.class;

    @Override
	protected CreateResult<MyExample55DTO> doCreateEntity(MyEntity55 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample55DTO> doUpdateEntity(MyEntity55 entity, MyExample55DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample55DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample55DTO> getActions() {
		return Actions.<MyExample55DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
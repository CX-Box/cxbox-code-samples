package org.demo.documentation.fields.hint.drilldown;

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
public class MyExample161Service extends VersionAwareResponseService<MyExample161DTO, MyEntity161> {

	private final MyEntity161Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample161Meta> meta = MyExample161Meta.class;

    @Override
	protected CreateResult<MyExample161DTO> doCreateEntity(MyEntity161 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample161DTO> doUpdateEntity(MyEntity161 entity, MyExample161DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample161DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample161DTO> getActions() {
		return Actions.<MyExample161DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
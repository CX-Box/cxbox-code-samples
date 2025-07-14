package org.demo.documentation.fields.text.required;

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
public class MyExample47Service extends VersionAwareResponseService<MyExample47DTO, MyEntity47> {

	private final MyEntity47Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample47Meta> meta = MyExample47Meta.class;

    @Override
	protected CreateResult<MyExample47DTO> doCreateEntity(MyEntity47 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample47DTO> doUpdateEntity(MyEntity47 entity, MyExample47DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample47DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample47DTO> getActions() {
		return Actions.<MyExample47DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
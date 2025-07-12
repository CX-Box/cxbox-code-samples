package org.demo.documentation.fields.money.required;

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
public class MyExample65Service extends VersionAwareResponseService<MyExample65DTO, MyEntity65> {

	private final MyEntity65Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample65Meta> meta = MyExample65Meta.class;

    @Override
	protected CreateResult<MyExample65DTO> doCreateEntity(MyEntity65 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample65DTO> doUpdateEntity(MyEntity65 entity, MyExample65DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample65DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample65DTO> getActions() {
		return Actions.<MyExample65DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
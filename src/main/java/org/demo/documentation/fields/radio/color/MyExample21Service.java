package org.demo.documentation.fields.radio.color;

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
public class MyExample21Service extends VersionAwareResponseService<MyExample21DTO, MyEntity21> {

	private final MyEntity21Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample21Meta> meta = MyExample21Meta.class;

    @Override
	protected CreateResult<MyExample21DTO> doCreateEntity(MyEntity21 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample21DTO> doUpdateEntity(MyEntity21 entity, MyExample21DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample21DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample21DTO> getActions() {
		return Actions.<MyExample21DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
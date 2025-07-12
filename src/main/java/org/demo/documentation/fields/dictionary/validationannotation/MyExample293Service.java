package org.demo.documentation.fields.dictionary.validationannotation;

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
public class MyExample293Service extends VersionAwareResponseService<MyExample293DTO, MyEntity293> {

	private final MyEntity293Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample293Meta> meta = MyExample293Meta.class;

    @Override
	protected CreateResult<MyExample293DTO> doCreateEntity(MyEntity293 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample293DTO> doUpdateEntity(MyEntity293 entity, MyExample293DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample293DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample293DTO> getActions() {
		return Actions.<MyExample293DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
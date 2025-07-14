package org.demo.documentation.fields.dictionary.validationruntimeex;

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
public class MyExample93Service extends VersionAwareResponseService<MyExample93DTO, MyEntity93> {

	private final MyEntity93Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample93Meta> meta = MyExample93Meta.class;

    @Override
	protected CreateResult<MyExample93DTO> doCreateEntity(MyEntity93 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample93DTO> doUpdateEntity(MyEntity93 entity, MyExample93DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample93DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample93DTO> getActions() {
		return Actions.<MyExample93DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
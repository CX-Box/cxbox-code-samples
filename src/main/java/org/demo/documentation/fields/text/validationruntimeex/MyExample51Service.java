package org.demo.documentation.fields.text.validationruntimeex;

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
public class MyExample51Service extends VersionAwareResponseService<MyExample51DTO, MyEntity51> {

	private final MyEntity51Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample51Meta> meta = MyExample51Meta.class;

    @Override
	protected CreateResult<MyExample51DTO> doCreateEntity(MyEntity51 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample51DTO> doUpdateEntity(MyEntity51 entity, MyExample51DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample51DTO_.customField)) {
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
	public Actions<MyExample51DTO> getActions() {
		return Actions.<MyExample51DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
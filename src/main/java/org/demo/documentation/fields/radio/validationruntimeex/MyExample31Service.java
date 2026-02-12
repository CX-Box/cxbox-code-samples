package org.demo.documentation.fields.radio.validationruntimeex;

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
public class MyExample31Service extends VersionAwareResponseService<MyExample31DTO, MyEntity31> {

	private final MyEntity31Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample31Meta> meta = MyExample31Meta.class;

	@Override
	protected CreateResult<MyExample31DTO> doCreateEntity(MyEntity31 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample31DTO> doUpdateEntity(MyEntity31 entity, MyExample31DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample31DTO_.customField)) {
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
	public Actions<MyExample31DTO> getActions() {
		return Actions.<MyExample31DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
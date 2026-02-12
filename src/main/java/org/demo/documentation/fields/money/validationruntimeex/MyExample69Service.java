package org.demo.documentation.fields.money.validationruntimeex;

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
public class MyExample69Service extends VersionAwareResponseService<MyExample69DTO, MyEntity69> {

	private final MyEntity69Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample69Meta> meta = MyExample69Meta.class;

	@Override
	protected CreateResult<MyExample69DTO> doCreateEntity(MyEntity69 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample69DTO> doUpdateEntity(MyEntity69 entity, MyExample69DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample69DTO_.customField)) {
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
	public Actions<MyExample69DTO> getActions() {
		return Actions.<MyExample69DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
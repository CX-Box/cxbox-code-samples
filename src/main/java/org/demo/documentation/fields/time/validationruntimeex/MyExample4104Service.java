package org.demo.documentation.fields.time.validationruntimeex;

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
public class MyExample4104Service extends VersionAwareResponseService<MyExample4104DTO, MyEntity4104> {

	private final MyEntity4104Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4104Meta> meta = MyExample4104Meta.class;

	@Override
	protected CreateResult<MyExample4104DTO> doCreateEntity(MyEntity4104 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample4104DTO> doUpdateEntity(MyEntity4104 entity, MyExample4104DTO data, BusinessComponent bc) {

		if (data.isFieldChanged(MyExample4104DTO_.customField)) {
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
	public Actions<MyExample4104DTO> getActions() {
		return Actions.<MyExample4104DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
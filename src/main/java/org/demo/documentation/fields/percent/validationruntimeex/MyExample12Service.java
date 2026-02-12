package org.demo.documentation.fields.percent.validationruntimeex;

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
public class MyExample12Service extends VersionAwareResponseService<MyExample12DTO, MyEntity12> {

	private final MyEntity12Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample12Meta> meta = MyExample12Meta.class;

	@Override
	protected CreateResult<MyExample12DTO> doCreateEntity(MyEntity12 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample12DTO> doUpdateEntity(MyEntity12 entity, MyExample12DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample12DTO_.customField)) {
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
	public Actions<MyExample12DTO> getActions() {
		return Actions.<MyExample12DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
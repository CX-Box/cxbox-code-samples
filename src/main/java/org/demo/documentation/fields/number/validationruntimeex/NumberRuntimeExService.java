package org.demo.documentation.fields.number.validationruntimeex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class NumberRuntimeExService extends VersionAwareResponseService<NumberRuntimeExDTO, NumberRuntimeExEntity> {

	private final NumberRuntimeExEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<NumberRuntimeExMeta> meta = NumberRuntimeExMeta.class;

	@Override
	protected CreateResult<NumberRuntimeExDTO> doCreateEntity(NumberRuntimeExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberRuntimeExDTO> doUpdateEntity(NumberRuntimeExEntity entity, NumberRuntimeExDTO data,
																 BusinessComponent bc) {
		if (data.isFieldChanged(NumberRuntimeExDTO_.customField)) {
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
	public Actions<NumberRuntimeExDTO> getActions() {
		return Actions.<NumberRuntimeExDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}
package org.demo.documentation.fields.multipleselect.validationruntimeex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.validationruntimeex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample249Service extends VersionAwareResponseService<MyExample249DTO, MyEntity249> {

	private final MyEntity249Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample249Meta> meta = MyExample249Meta.class;

	@Override
	protected CreateResult<MyExample249DTO> doCreateEntity(MyEntity249 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample249DTO> doUpdateEntity(MyEntity249 entity, MyExample249DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample249DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
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
	public Actions<MyExample249DTO> getActions() {
		return Actions.<MyExample249DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
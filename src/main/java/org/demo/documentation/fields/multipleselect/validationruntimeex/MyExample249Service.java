package org.demo.documentation.fields.multipleselect.validationruntimeex;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.validationruntimeex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample249Service extends VersionAwareResponseService<MyExample249DTO, MyEntity249> {

	private final MyEntity249Repository repository;

	public MyExample249Service(MyEntity249Repository repository) {
		super(MyExample249DTO.class, MyEntity249.class, null, MyExample249Meta.class);
		this.repository = repository;
	}

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
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}
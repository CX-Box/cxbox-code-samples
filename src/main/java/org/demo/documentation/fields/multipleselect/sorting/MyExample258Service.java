package org.demo.documentation.fields.multipleselect.sorting;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.sorting.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample258Service extends VersionAwareResponseService<MyExample258DTO, MyEntity258> {

	private final MyEntity258Repository repository;

	public MyExample258Service(MyEntity258Repository repository) {
		super(MyExample258DTO.class, MyEntity258.class, null, MyExample258Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample258DTO> doCreateEntity(MyEntity258 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample258DTO> doUpdateEntity(MyEntity258 entity, MyExample258DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample258DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample258DTO> getActions() {
		return Actions.<MyExample258DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}
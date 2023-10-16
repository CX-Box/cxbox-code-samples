package org.demo.documentation.multipleselect.filtration;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.filtration.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample256Service extends VersionAwareResponseService<MyExample256DTO, MyEntity256> {

	private final MyEntity256Repository repository;

	public MyExample256Service(MyEntity256Repository repository) {
		super(MyExample256DTO.class, MyEntity256.class, null, MyExample256Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample256DTO> doCreateEntity(MyEntity256 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample256DTO> doUpdateEntity(MyEntity256 entity, MyExample256DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample256DTO_.customField)) {
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
	public Actions<MyExample256DTO> getActions() {
		return Actions.<MyExample256DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}
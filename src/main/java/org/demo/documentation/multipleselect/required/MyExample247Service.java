package org.demo.documentation.multipleselect.required;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.required.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample247Service extends VersionAwareResponseService<MyExample247DTO, MyEntity247> {

	private final MyEntity247Repository repository;

	public MyExample247Service(MyEntity247Repository repository) {
		super(MyExample247DTO.class, MyEntity247.class, null, MyExample247Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample247DTO> doCreateEntity(MyEntity247 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample247DTO> doUpdateEntity(MyEntity247 entity, MyExample247DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample247DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample247DTO> getActions() {
		return Actions.<MyExample247DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
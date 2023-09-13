package org.demo.documentation.multipleselect.validationannotation;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.validationannotation.enums.CustomFieldEnum;
import org.demo.services.CustomDynamicErrorService;
import org.springframework.stereotype.Service;

@Service
public class MyExample345Service extends VersionAwareResponseService<MyExample345DTO, MyEntity345> {

	private final MyEntity345Repository repository;

	public MyExample345Service(MyEntity345Repository repository) {
		super(MyExample345DTO.class, MyEntity345.class, null, MyExample345Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample345DTO> doCreateEntity(MyEntity345 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample345DTO> doUpdateEntity(MyEntity345 entity, MyExample345DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample345DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample345DTO> getActions() {
		return Actions.<MyExample345DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
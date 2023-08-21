package org.demo.documentation.multipleselect.placeholder;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.placeholder.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample257Service extends VersionAwareResponseService<MyExample257DTO, MyEntity257> {

	private final MyEntity257Repository repository;

	public MyExample257Service(MyEntity257Repository repository) {
		super(MyExample257DTO.class, MyEntity257.class, null, MyExample257Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample257DTO> doCreateEntity(MyEntity257 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample257DTO> doUpdateEntity(MyEntity257 entity, MyExample257DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample257DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample257DTO> getActions() {
		return Actions.<MyExample257DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
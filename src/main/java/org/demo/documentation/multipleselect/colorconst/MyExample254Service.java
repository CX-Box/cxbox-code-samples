package org.demo.documentation.multipleselect.colorconst;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.colorconst.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample254Service extends VersionAwareResponseService<MyExample254DTO, MyEntity254> {

	private final MyEntity254Repository repository;

	public MyExample254Service(MyEntity254Repository repository) {
		super(MyExample254DTO.class, MyEntity254.class, null, MyExample254Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample254DTO> doCreateEntity(MyEntity254 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample254DTO> doUpdateEntity(MyEntity254 entity, MyExample254DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample254DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample254DTO> getActions() {
		return Actions.<MyExample254DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
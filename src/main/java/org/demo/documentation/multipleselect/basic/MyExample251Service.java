package org.demo.documentation.multipleselect.basic;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample251Service extends VersionAwareResponseService<MyExample251DTO, MyEntity251> {

	private final MyEntity251Repository repository;

	public MyExample251Service(MyEntity251Repository repository) {
		super(MyExample251DTO.class, MyEntity251.class, null, MyExample251Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample251DTO> doCreateEntity(MyEntity251 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample251DTO> doUpdateEntity(MyEntity251 entity, MyExample251DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample251DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample251DTO> getActions() {
		return Actions.<MyExample251DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
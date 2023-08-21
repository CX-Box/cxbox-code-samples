package org.demo.documentation.multipleselect.color;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.color.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample250Service extends VersionAwareResponseService<MyExample250DTO, MyEntity250> {

	private final MyEntity250Repository repository;

	public MyExample250Service(MyEntity250Repository repository) {
		super(MyExample250DTO.class, MyEntity250.class, null, MyExample250Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample250DTO> doCreateEntity(MyEntity250 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample250DTO> doUpdateEntity(MyEntity250 entity, MyExample250DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample250DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample250DTO> getActions() {
		return Actions.<MyExample250DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
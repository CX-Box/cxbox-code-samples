package org.demo.documentation.multipleselect.drilldown;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.drilldown.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample255Service extends VersionAwareResponseService<MyExample255DTO, MyEntity255> {

	private final MyEntity255Repository repository;

	public MyExample255Service(MyEntity255Repository repository) {
		super(MyExample255DTO.class, MyEntity255.class, null, MyExample255Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample255DTO> doCreateEntity(MyEntity255 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample255DTO> doUpdateEntity(MyEntity255 entity, MyExample255DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample255DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample255DTO> getActions() {
		return Actions.<MyExample255DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
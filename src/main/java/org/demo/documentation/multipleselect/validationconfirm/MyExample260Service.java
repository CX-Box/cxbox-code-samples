package org.demo.documentation.multipleselect.validationconfirm;

import java.util.stream.Collectors;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.multipleselect.validationconfirm.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample260Service extends VersionAwareResponseService<MyExample260DTO, MyEntity260> {

	private final MyEntity260Repository repository;

	public MyExample260Service(MyEntity260Repository repository) {
		super(MyExample260DTO.class, MyEntity260.class, null, MyExample260Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample260DTO> doCreateEntity(MyEntity260 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample260DTO> doUpdateEntity(MyEntity260 entity, MyExample260DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample260DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample260DTO> getActions() {
		return Actions.<MyExample260DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}

}
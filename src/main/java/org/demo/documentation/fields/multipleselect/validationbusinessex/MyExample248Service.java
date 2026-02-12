package org.demo.documentation.fields.multipleselect.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample248Service extends VersionAwareResponseService<MyExample248DTO, MyEntity248> {

	private final MyEntity248Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample248Meta> meta = MyExample248Meta.class;

	@Override
	protected CreateResult<MyExample248DTO> doCreateEntity(MyEntity248 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample248DTO> doUpdateEntity(MyEntity248 entity, MyExample248DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample248DTO_.customField)) {
			data.getCustomField().getValues()
					.stream()
					.filter(val -> val.getValue().equals(CustomFieldEnum.HIGH.getValue()))
					.findFirst()
					.orElseThrow(() -> new BusinessException().addPopup("The field  can contain 'High'"));
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
	public Actions<MyExample248DTO> getActions() {
		return Actions.<MyExample248DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
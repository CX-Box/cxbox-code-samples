package org.demo.documentation.fields.multipleselect.validationdynamic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.validationdynamic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample334Service extends VersionAwareResponseService<MyExample334DTO, MyEntity334> {

	private final MyEntity334Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample334Meta> meta = MyExample334Meta.class;

    @Override
	protected CreateResult<MyExample334DTO> doCreateEntity(MyEntity334 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample334DTO> doUpdateEntity(MyEntity334 entity, MyExample334DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample334DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample334DTO_.customFieldAdditional)) {
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
	public Actions<MyExample334DTO> getActions() {
		return Actions.<MyExample334DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample334DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		boolean customFieldFlg = dto.getCustomField().getValues()
				.stream()
				.anyMatch(val ->
						CustomFieldEnum.HIGH.getValue().equals(val.getValue()));
		boolean customFieldAdditionalFlg = dto.getCustomFieldAdditional().getValues()
				.stream()
				.anyMatch(val ->
						CustomFieldEnum.HIGH.getValue().equals(val.getValue()));
		if (customFieldFlg) {
			entity.addField(
					MyExample334DTO_.customField.getName(),
					"Custom message about error"
			);
		}
		if  (customFieldAdditionalFlg) {
			entity.addField(
					MyExample334DTO_.customFieldAdditional.getName(),
					"Custom message about error"
			);
		}
		if (!entity.getFields().isEmpty()) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}
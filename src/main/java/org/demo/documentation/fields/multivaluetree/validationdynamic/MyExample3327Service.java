package org.demo.documentation.fields.multivaluetree.validationdynamic;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3327Service extends VersionAwareResponseService<MyExample3327DTO, MyEntity3327> {

	private final MyEntity3327Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3327Meta> meta = MyExample3327Meta.class;


	@Override
	protected CreateResult<MyExample3327DTO> doCreateEntity(MyEntity3327 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3327DTO> doUpdateEntity(MyEntity3327 entity, MyExample3327DTO data,
															  BusinessComponent bc) {
		validateFields(bc, data);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3327DTO> getActions() {
		return Actions.<MyExample3327DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample3327DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(MyExample3327DTO_.customField.getName(), "Custom message about required field");
		}
		if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(MyExample3327DTO_.customFieldAdditional.getName(), "Custom message about required field");
		}
		if (!entity.getFields().isEmpty()) {
			throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}
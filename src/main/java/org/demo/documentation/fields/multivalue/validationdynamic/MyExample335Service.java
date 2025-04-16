package org.demo.documentation.fields.multivalue.validationdynamic;


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
public class MyExample335Service extends VersionAwareResponseService<MyExample335DTO, MyEntity335> {

	private final MyEntity335Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample335Meta> meta = MyExample335Meta.class;


    @Override
	protected CreateResult<MyExample335DTO> doCreateEntity(MyEntity335 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample335DTO> doUpdateEntity(MyEntity335 entity, MyExample335DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample335DTO> getActions() {
		return Actions.<MyExample335DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample335DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(MyExample335DTO_.customField.getName(), "Custom message about required field");
		}
		if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(MyExample335DTO_.customFieldAdditional.getName(), "Custom message about required field");
		}
		if (!entity.getFields().isEmpty()) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}
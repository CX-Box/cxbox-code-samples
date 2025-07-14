package org.demo.documentation.fields.money.validationdynamic;

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
public class MyExample333Service extends VersionAwareResponseService<MyExample333DTO, MyEntity333> {

	private final MyEntity333Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample333Meta> meta = MyExample333Meta.class;


    @Override
	protected CreateResult<MyExample333DTO> doCreateEntity(MyEntity333 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample333DTO> doUpdateEntity(MyEntity333 entity, MyExample333DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample333DTO> getActions() {
		return Actions.<MyExample333DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample333DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (dto.getCustomField() < 100000) {
			entity.addField(MyExample333DTO_.customField.getName(), "The field 'customField' cannot be less than 100 000.00");
		}
		if (dto.getCustomField() < 100000) {
			entity.addField(
					MyExample333DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' cannot be less than 100 000.00"
			);
		}
		if (!entity.getFields().isEmpty()) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}
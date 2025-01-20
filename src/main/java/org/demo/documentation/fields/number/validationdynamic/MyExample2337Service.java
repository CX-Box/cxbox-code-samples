package org.demo.documentation.fields.number.validationdynamic;


import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample2337Service extends VersionAwareResponseService<MyExample2337DTO, MyEntity2337> {

	private final MyEntity2337Repository repository;

	public MyExample2337Service(MyEntity2337Repository repository) {
		super(MyExample2337DTO.class, MyEntity2337.class, null, MyExample2337Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample2337DTO> doCreateEntity(MyEntity2337 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample2337DTO> doUpdateEntity(MyEntity2337 entity, MyExample2337DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample2337DTO> getActions() {
		return Actions.<MyExample2337DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample2337DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (dto.getCustomField() < 100000) {
			entity.addField(MyExample2337DTO_.customField.getName(), "The field 'customField' cannot be less than 100 000.");
		}
		if (dto.getCustomField() < 100000) {
			entity.addField(
					MyExample2337DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' cannot be less than 100 000."
			);
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}
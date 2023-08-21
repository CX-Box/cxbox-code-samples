package org.demo.documentation.money.validationdynamic;

import static org.cxbox.api.util.i18n.ErrorMessageSource.errorMessage;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample333Service extends VersionAwareResponseService<MyExample333DTO, MyEntity333> {

	private final MyEntity333Repository repository;


	public MyExample333Service(MyEntity333Repository repository) {
		super(MyExample333DTO.class, MyEntity333.class, null, MyExample333Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample333DTO> doCreateEntity(MyEntity333 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample333DTO> doUpdateEntity(MyEntity333 entity, MyExample333DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample333DTO> getActions() {
		return Actions.<MyExample333DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.action("check", "Check")
				.invoker((bc, dto) -> {
					validate(bc, dto);
					return new ActionResultDTO<>();
				})
				.add()
				.build();
	}

	private void validate(BusinessComponent bc, MyExample333DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (dto.getCustomField() < 100000) {
			entity.addField(
					MyExample333DTO_.customField.getName(),
					errorMessage("The field 'customField' cannot be less than 100 000.00")
			);
		}
		if (dto.getCustomField() < 100000) {
			entity.addField(
					MyExample333DTO_.customFieldAdditional.getName(),
					errorMessage("The field 'customFieldAdditional' cannot be less than 100 000.00")
			);
		}
		if (entity.getFields().size() > 0) {
			throw new BusinessException().setEntity(entity);
		}
	}

}
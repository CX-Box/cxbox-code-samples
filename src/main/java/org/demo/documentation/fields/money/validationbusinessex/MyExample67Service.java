package org.demo.documentation.fields.money.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.LESS_100000;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample67Service extends VersionAwareResponseService<MyExample67DTO, MyEntity67> {

	private final MyEntity67Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample67Meta> meta = MyExample67Meta.class;

    @Override
	protected CreateResult<MyExample67DTO> doCreateEntity(MyEntity67 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample67DTO> doUpdateEntity(MyEntity67 entity, MyExample67DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample67DTO_.customField)) {
			if (data.getCustomField() < 100000) {
				throw new BusinessException().addPopup(LESS_100000);
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample67DTO> getActions() {
		return Actions.<MyExample67DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.percent.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.LESS_10;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample10Service extends VersionAwareResponseService<MyExample10DTO, MyEntity10> {

	private final MyEntity10Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample10Meta> meta = MyExample10Meta.class;

    @Override
	protected CreateResult<MyExample10DTO> doCreateEntity(MyEntity10 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample10DTO> doUpdateEntity(MyEntity10 entity, MyExample10DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample10DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			if (data.getCustomField() < 10) {
				throw new BusinessException().addPopup(LESS_10);
			}
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample10DTO> getActions() {
		return Actions.<MyExample10DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.checkbox.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_TRUE;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample77Service extends VersionAwareResponseService<MyExample77DTO, MyEntity77> {

	private final MyEntity77Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample77Meta> meta = MyExample77Meta.class;

    @Override
	protected CreateResult<MyExample77DTO> doCreateEntity(MyEntity77 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample77DTO> doUpdateEntity(MyEntity77 entity, MyExample77DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample77DTO_.customField)) {
			if (Boolean.FALSE.equals(data.getCustomField())) {
				throw new BusinessException().addPopup(ONLY_TRUE);
			}
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample77DTO> getActions() {
		return Actions.<MyExample77DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.fields.dictionary.validationannotationcustom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample169Service extends VersionAwareResponseService<MyExample169DTO, MyEntity169> {

	private final MyEntity169Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample169Meta> meta = MyExample169Meta.class;

    @Override
	protected CreateResult<MyExample169DTO> doCreateEntity(MyEntity169 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample169DTO> doUpdateEntity(MyEntity169 entity, MyExample169DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample169DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample169DTO> getActions() {
		return Actions.<MyExample169DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
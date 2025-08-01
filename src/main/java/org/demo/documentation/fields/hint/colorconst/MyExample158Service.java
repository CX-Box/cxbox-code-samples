package org.demo.documentation.fields.hint.colorconst;

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
public class MyExample158Service extends VersionAwareResponseService<MyExample158DTO, MyEntity158> {

	private final MyEntity158Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample158Meta> meta = MyExample158Meta.class;

    @Override
	protected CreateResult<MyExample158DTO> doCreateEntity(MyEntity158 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample158DTO> doUpdateEntity(MyEntity158 entity, MyExample158DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample158DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample158DTO> getActions() {
		return Actions.<MyExample158DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
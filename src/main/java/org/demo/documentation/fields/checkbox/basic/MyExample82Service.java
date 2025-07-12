package org.demo.documentation.fields.checkbox.basic;

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
public class MyExample82Service extends VersionAwareResponseService<MyExample82DTO, MyEntity82> {

	private final MyEntity82Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample82Meta> meta = MyExample82Meta.class;

    @Override
	protected CreateResult<MyExample82DTO> doCreateEntity(MyEntity82 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample82DTO> doUpdateEntity(MyEntity82 entity, MyExample82DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample82DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample82DTO> getActions() {
		return Actions.<MyExample82DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
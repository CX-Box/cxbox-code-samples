package org.demo.documentation.fields.text.sorting;

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
public class MyExample48Service extends VersionAwareResponseService<MyExample48DTO, MyEntity48> {

	private final MyEntity48Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample48Meta> meta = MyExample48Meta.class;

    @Override
	protected CreateResult<MyExample48DTO> doCreateEntity(MyEntity48 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample48DTO> doUpdateEntity(MyEntity48 entity, MyExample48DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample48DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample48DTO> getActions() {
		return Actions.<MyExample48DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
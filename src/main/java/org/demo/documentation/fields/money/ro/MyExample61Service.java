package org.demo.documentation.fields.money.ro;

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
public class MyExample61Service extends VersionAwareResponseService<MyExample61DTO, MyEntity61> {

	private final MyEntity61Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample61Meta> meta = MyExample61Meta.class;

    @Override
	protected CreateResult<MyExample61DTO> doCreateEntity(MyEntity61 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample61DTO> doUpdateEntity(MyEntity61 entity, MyExample61DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample61DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample61DTO> getActions() {
		return Actions.<MyExample61DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
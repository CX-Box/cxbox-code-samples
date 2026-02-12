package org.demo.documentation.fields.money.colorconst;

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
public class MyExample60Service extends VersionAwareResponseService<MyExample60DTO, MyEntity60> {

	private final MyEntity60Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample60Meta> meta = MyExample60Meta.class;

	@Override
	protected CreateResult<MyExample60DTO> doCreateEntity(MyEntity60 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample60DTO> doUpdateEntity(MyEntity60 entity, MyExample60DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample60DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample60DTO> getActions() {
		return Actions.<MyExample60DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
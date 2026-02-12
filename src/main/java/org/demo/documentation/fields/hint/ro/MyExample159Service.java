package org.demo.documentation.fields.hint.ro;

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
public class MyExample159Service extends VersionAwareResponseService<MyExample159DTO, MyEntity159> {

	private final MyEntity159Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample159Meta> meta = MyExample159Meta.class;

	@Override
	protected CreateResult<MyExample159DTO> doCreateEntity(MyEntity159 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample159DTO> doUpdateEntity(MyEntity159 entity, MyExample159DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample159DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample159DTO> getActions() {
		return Actions.<MyExample159DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
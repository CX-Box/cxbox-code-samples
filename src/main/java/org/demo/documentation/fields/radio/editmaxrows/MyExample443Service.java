package org.demo.documentation.fields.radio.editmaxrows;

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
public class MyExample443Service extends VersionAwareResponseService<MyExample443DTO, MyEntity443> {

	private final MyEntity443Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample443Meta> meta = MyExample443Meta.class;

	@Override
	protected CreateResult<MyExample443DTO> doCreateEntity(MyEntity443 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample443DTO> doUpdateEntity(MyEntity443 entity, MyExample443DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample443DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample443DTO> getActions() {
		return Actions.<MyExample443DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
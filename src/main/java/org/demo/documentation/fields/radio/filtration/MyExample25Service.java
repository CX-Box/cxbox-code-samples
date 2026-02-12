package org.demo.documentation.fields.radio.filtration;

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
public class MyExample25Service extends VersionAwareResponseService<MyExample25DTO, MyEntity25> {

	private final MyEntity25Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample25Meta> meta = MyExample25Meta.class;

	@Override
	protected CreateResult<MyExample25DTO> doCreateEntity(MyEntity25 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample25DTO> doUpdateEntity(MyEntity25 entity, MyExample25DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample25DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample25DTO> getActions() {
		return Actions.<MyExample25DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
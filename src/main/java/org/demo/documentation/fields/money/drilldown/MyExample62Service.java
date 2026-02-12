package org.demo.documentation.fields.money.drilldown;

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
public class MyExample62Service extends VersionAwareResponseService<MyExample62DTO, MyEntity62> {

	private final MyEntity62Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample62Meta> meta = MyExample62Meta.class;

	@Override
	protected CreateResult<MyExample62DTO> doCreateEntity(MyEntity62 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample62DTO> doUpdateEntity(MyEntity62 entity, MyExample62DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample62DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample62DTO> getActions() {
		return Actions.<MyExample62DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
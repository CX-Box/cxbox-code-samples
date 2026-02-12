package org.demo.documentation.fields.suggestion.drilldown.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3095Service extends VersionAwareResponseService<MyExample3095DTO, MyEntity3095> {

	private final MyEntity3095Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3095Meta> meta = MyExample3095Meta.class;

	@Override
	protected CreateResult<MyExample3095DTO> doCreateEntity(MyEntity3095 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3095DTO> doUpdateEntity(MyEntity3095 entity, MyExample3095DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3095DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3095DTO> getActions() {
		return Actions.<MyExample3095DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}

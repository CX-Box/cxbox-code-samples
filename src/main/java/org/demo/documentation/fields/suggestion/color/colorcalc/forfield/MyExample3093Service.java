package org.demo.documentation.fields.suggestion.color.colorcalc.forfield;

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
public class MyExample3093Service extends VersionAwareResponseService<MyExample3093DTO, MyEntity3093> {

	private final MyEntity3093Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3093Meta> meta = MyExample3093Meta.class;

	@Override
	protected CreateResult<MyExample3093DTO> doCreateEntity(MyEntity3093 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3093DTO> doUpdateEntity(MyEntity3093 entity, MyExample3093DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3093DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3093DTO> getActions() {
		return Actions.<MyExample3093DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}

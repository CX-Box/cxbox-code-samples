package org.demo.documentation.fields.richtext.placeholder;

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
public class MyExample426Service extends VersionAwareResponseService<MyExample426DTO, MyEntity426> {

	private final MyEntity426Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample426Meta> meta = MyExample426Meta.class;

	@Override
	protected CreateResult<MyExample426DTO> doCreateEntity(MyEntity426 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample426DTO> doUpdateEntity(MyEntity426 entity, MyExample426DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample426DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample426DTO> getActions() {
		return Actions.<MyExample426DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
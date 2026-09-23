package org.demo.documentation.fields.richtext.filtrationplaintext;

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
public class MyExample438Service extends VersionAwareResponseService<MyExample438DTO, MyEntity438> {

	private final MyEntity438Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample438Meta> meta = MyExample438Meta.class;

	@Override
	protected CreateResult<MyExample438DTO> doCreateEntity(MyEntity438 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample438DTO> doUpdateEntity(MyEntity438 entity, MyExample438DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample438DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample438DTO> getActions() {
		return Actions.<MyExample438DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
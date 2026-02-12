package org.demo.documentation.fields.time.placeholder;

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
public class MyExample3505Service extends VersionAwareResponseService<MyExample3505DTO, MyEntity3505> {

	private final MyEntity3505Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3505Meta> meta = MyExample3505Meta.class;

	@Override
	protected CreateResult<MyExample3505DTO> doCreateEntity(MyEntity3505 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3505DTO> doUpdateEntity(MyEntity3505 entity, MyExample3505DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3505DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3505DTO> getActions() {
		return Actions.<MyExample3505DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
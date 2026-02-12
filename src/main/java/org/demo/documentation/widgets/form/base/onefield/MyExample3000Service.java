package org.demo.documentation.widgets.form.base.onefield;

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
public class MyExample3000Service extends VersionAwareResponseService<MyExample3000DTO, MyEntity3000> {

	private final MyEntity3000Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3000Meta> meta = MyExample3000Meta.class;

	@Override
	protected CreateResult<MyExample3000DTO> doCreateEntity(MyEntity3000 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3000DTO> doUpdateEntity(MyEntity3000 entity, MyExample3000DTO data,
															   BusinessComponent bc) {

		if (data.isFieldChanged(MyExample3000DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3000DTO> getActions() {
		return Actions.<MyExample3000DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
package org.demo.documentation.widgets.form.showcondition.byparententity.parent;

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
public class MyExample3007Service extends VersionAwareResponseService<MyExample3007DTO, MyEntity3007> {

	private final MyEntity3007Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3007Meta> meta = MyExample3007Meta.class;

	@Override
	protected CreateResult<MyExample3007DTO> doCreateEntity(MyEntity3007 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3007DTO> doUpdateEntity(MyEntity3007 entity, MyExample3007DTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3007DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3007DTO> getActions() {
		return Actions.<MyExample3007DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt.text("Add"))
				.build();
	}
	// --8<-- [end:getActions]

}
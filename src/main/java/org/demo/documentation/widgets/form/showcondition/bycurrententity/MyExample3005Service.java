package org.demo.documentation.widgets.form.showcondition.bycurrententity;

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
public class MyExample3005Service extends VersionAwareResponseService<MyExample3005DTO, MyEntity3005> {

	private final MyEntity3005Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3005Meta> meta = MyExample3005Meta.class;

	@Override
	protected CreateResult<MyExample3005DTO> doCreateEntity(MyEntity3005 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3005DTO> doUpdateEntity(MyEntity3005 entity, MyExample3005DTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3005DTO_.customField2)) {
			entity.setCustomField2(data.getCustomField2());
		}
		if (data.isFieldChanged(MyExample3005DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3005DTO> getActions() {
		return Actions.<MyExample3005DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt.text("Add"))
				.build();
	}
	// --8<-- [end:getActions]

}
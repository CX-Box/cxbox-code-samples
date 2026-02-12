package org.demo.documentation.fields.money.filtration;

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
public class MyExample63Service extends VersionAwareResponseService<MyExample63DTO, MyEntity63> {

	private final MyEntity63Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample63Meta> meta = MyExample63Meta.class;

	@Override
	protected CreateResult<MyExample63DTO> doCreateEntity(MyEntity63 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample63DTO> doUpdateEntity(MyEntity63 entity, MyExample63DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample63DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample63DTO> getActions() {
		return Actions.<MyExample63DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
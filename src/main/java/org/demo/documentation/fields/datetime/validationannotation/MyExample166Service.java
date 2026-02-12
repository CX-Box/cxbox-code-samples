package org.demo.documentation.fields.datetime.validationannotation;

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
public class MyExample166Service extends VersionAwareResponseService<MyExample166DTO, MyEntity166> {

	private final MyEntity166Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample166Meta> meta = MyExample166Meta.class;

	@Override
	protected CreateResult<MyExample166DTO> doCreateEntity(MyEntity166 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample166DTO> doUpdateEntity(MyEntity166 entity, MyExample166DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample166DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample166DTO> getActions() {
		return Actions.<MyExample166DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
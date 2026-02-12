package org.demo.documentation.widgets.assoc.actions.other.createwithparent.parent;

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
public class MyExample3661Service extends VersionAwareResponseService<MyExample3661DTO, MyEntity3661> {

	private final MyEntity3661Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3661Meta> meta = MyExample3661Meta.class;

	@Override
	protected CreateResult<MyExample3661DTO> doCreateEntity(MyEntity3661 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3661DTO> doUpdateEntity(MyEntity3661 entity, MyExample3661DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3661DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3661DTO> getActions() {
		return Actions.<MyExample3661DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

package org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent;

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
public class MyExample3338Service extends VersionAwareResponseService<MyExample3338DTO, MyEntity3338> {

	private final MyEntity3338Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3338Meta> meta = MyExample3338Meta.class;

	@Override
	protected CreateResult<MyExample3338DTO> doCreateEntity(MyEntity3338 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3338DTO> doUpdateEntity(MyEntity3338 entity, MyExample3338DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3338DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3338DTO> getActions() {
		return Actions.<MyExample3338DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

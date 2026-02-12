package org.demo.documentation.feature.drilldown.goingbackafterdrilldowncreate;

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
public class MyExample3622Service extends VersionAwareResponseService<MyExample3622DTO, MyEntity3622> {

	private final MyEntity3622Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3622Meta> meta = MyExample3622Meta.class;

	@Override
	protected CreateResult<MyExample3622DTO> doCreateEntity(MyEntity3622 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3622DTO> doUpdateEntity(MyEntity3622 entity, MyExample3622DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3622DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3622DTO> getActions() {
		return Actions.<MyExample3622DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

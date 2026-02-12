package org.demo.documentation.feature.drilldown.byscreen;

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
public class MyExample3619Service extends VersionAwareResponseService<MyExample3619DTO, MyEntity3619> {

	private final MyEntity3619Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3619Meta> meta = MyExample3619Meta.class;

	@Override
	protected CreateResult<MyExample3619DTO> doCreateEntity(MyEntity3619 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3619DTO> doUpdateEntity(MyEntity3619 entity, MyExample3619DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3619DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3619DTO> getActions() {
		return Actions.<MyExample3619DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

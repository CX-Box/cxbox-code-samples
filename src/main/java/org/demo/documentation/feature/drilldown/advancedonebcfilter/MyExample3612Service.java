package org.demo.documentation.feature.drilldown.advancedonebcfilter;

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
public class MyExample3612Service extends VersionAwareResponseService<MyExample3612DTO, MyEntity3612> {

	private final MyEntity3612Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3612Meta> meta = MyExample3612Meta.class;

	@Override
	protected CreateResult<MyExample3612DTO> doCreateEntity(MyEntity3612 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3612DTO> doUpdateEntity(MyEntity3612 entity, MyExample3612DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3612DTO_.customFieldFilterDictionary)) {
			entity.setCustomFieldFilterDictionary(data.getCustomFieldFilterDictionary());
		}
		if (data.isFieldChanged(MyExample3612DTO_.customFieldFilterDate)) {
			entity.setCustomFieldFilterDate(data.getCustomFieldFilterDate());
		}
		if (data.isFieldChanged(MyExample3612DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3612DTO> getActions() {
		return Actions.<MyExample3612DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}

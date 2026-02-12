package org.demo.documentation.feature.drilldown.simple;

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
public class MyExample3611Service extends VersionAwareResponseService<MyExample3611DTO, MyEntity3611> {

	private final MyEntity3611Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3611Meta> meta = MyExample3611Meta.class;

	@Override
	protected CreateResult<MyExample3611DTO> doCreateEntity(MyEntity3611 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3611DTO> doUpdateEntity(MyEntity3611 entity, MyExample3611DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3611DTO_.customFieldDrillDowm)) {
			entity.setCustomFieldDrillDowm(data.getCustomFieldDrillDowm());
		}
		if (data.isFieldChanged(MyExample3611DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3611DTO> getActions() {
		return Actions.<MyExample3611DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
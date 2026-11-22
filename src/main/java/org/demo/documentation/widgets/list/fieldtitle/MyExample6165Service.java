package org.demo.documentation.widgets.list.fieldtitle;

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
public class MyExample6165Service extends VersionAwareResponseService<MyExample6165DTO, MyEntity6165> {

	private final MyEntity6165Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6165Meta> meta = MyExample6165Meta.class;

	@Override
	protected CreateResult<MyExample6165DTO> doCreateEntity(MyEntity6165 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6165DTO> doUpdateEntity(MyEntity6165 entity, MyExample6165DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample6165DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample6165DTO> getActions() {
		return Actions.<MyExample6165DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
}

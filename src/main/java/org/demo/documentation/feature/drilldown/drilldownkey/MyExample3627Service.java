package org.demo.documentation.feature.drilldown.drilldownkey;

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
public class MyExample3627Service extends VersionAwareResponseService<MyExample3627DTO, MyEntity3627> {

	private final MyEntity3627Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3627Meta> meta = MyExample3627Meta.class;

	@Override
	protected CreateResult<MyExample3627DTO> doCreateEntity(MyEntity3627 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3627DTO> doUpdateEntity(MyEntity3627 entity, MyExample3627DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3627DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3627DTO> getActions() {
		return Actions.<MyExample3627DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}

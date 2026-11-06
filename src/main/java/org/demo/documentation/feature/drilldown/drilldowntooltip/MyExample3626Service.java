package org.demo.documentation.feature.drilldown.drilldowntooltip;

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
public class MyExample3626Service extends VersionAwareResponseService<MyExample3626DTO, MyEntity3626> {

	private final MyEntity3626Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3626Meta> meta = MyExample3626Meta.class;

	@Override
	protected CreateResult<MyExample3626DTO> doCreateEntity(MyEntity3626 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3626DTO> doUpdateEntity(MyEntity3626 entity, MyExample3626DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3626DTO> getActions() {
		return Actions.<MyExample3626DTO>builder()
				.build();
	}

}

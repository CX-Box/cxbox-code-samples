package org.demo.documentation.widgets.cardcarousellist.showcondition.parent;

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
public class MyExample5063Service extends VersionAwareResponseService<MyExample5063DTO, MyEntity5063> {

	private final MyEntity5063Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5063Meta> meta = MyExample5063Meta.class;

	@Override
	protected CreateResult<MyExample5063DTO> doCreateEntity(MyEntity5063 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5063DTO> doUpdateEntity(MyEntity5063 entity, MyExample5063DTO data,
			BusinessComponent bc) {
		setIfChanged(data, MyExample5063DTO_.customFieldNumber, entity::setCustomFieldNumber);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5063DTO> getActions() {
		return Actions.<MyExample5063DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}

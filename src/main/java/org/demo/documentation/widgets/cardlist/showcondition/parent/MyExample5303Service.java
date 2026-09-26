package org.demo.documentation.widgets.cardlist.showcondition.parent;

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
public class MyExample5303Service extends VersionAwareResponseService<MyExample5303DTO, MyEntity5303> {

	private final MyEntity5303Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5303Meta> meta = MyExample5303Meta.class;

	@Override
	protected CreateResult<MyExample5303DTO> doCreateEntity(MyEntity5303 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5303DTO> doUpdateEntity(MyEntity5303 entity, MyExample5303DTO data,
			BusinessComponent bc) {
		setIfChanged(data, MyExample5303DTO_.customFieldNumber, entity::setCustomFieldNumber);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5303DTO> getActions() {
		return Actions.<MyExample5303DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}

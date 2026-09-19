package org.demo.documentation.feature.file.availability;

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
public class MyExample6104Service extends VersionAwareResponseService<MyExample6104DTO, MyEntity6104> {

	private final MyEntity6104Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6104Meta> meta = MyExample6104Meta.class;

	@Override
	protected CreateResult<MyExample6104DTO> doCreateEntity(MyEntity6104 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6104DTO> doUpdateEntity(MyEntity6104 entity, MyExample6104DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample6104DTO_.status, entity::setStatus);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample6104DTO> getActions() {
		return Actions.<MyExample6104DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}

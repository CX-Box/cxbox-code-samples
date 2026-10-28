package org.demo.documentation.additional.checkforceactiveshowcondition.basic;

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
public class MyExample1432Service extends VersionAwareResponseService<MyExample1432DTO, MyEntity1432> {

	private final MyEntity1432Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample1432Meta> meta = MyExample1432Meta.class;

	@Override
	protected CreateResult<MyExample1432DTO> doCreateEntity(MyEntity1432 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample1432DTO> doUpdateEntity(MyEntity1432 entity, MyExample1432DTO data,
															   BusinessComponent bc) {
		setIfChanged(data, MyExample1432DTO_.crsStatus, entity::setCrsStatus);
		if (data.isFieldChanged(MyExample1432DTO_.accountableCrs)) {
			entity.setAccountableCrs(data.getAccountableCrs() == null ? null : data.getAccountableCrs().isVal());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample1432DTO> getActions() {
		return Actions.<MyExample1432DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}

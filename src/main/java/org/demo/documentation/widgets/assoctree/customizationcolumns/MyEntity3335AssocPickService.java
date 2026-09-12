package org.demo.documentation.widgets.assoctree.customizationcolumns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3335AssocPickService extends VersionAwareResponseService<MyEntity3335AssocPickDTO, MyEntity3335Assoc> {
	private final MyEntity3335MultiRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3335AssocPickMeta> meta = MyEntity3335AssocPickMeta.class;

	@Override
	protected CreateResult<MyEntity3335AssocPickDTO> doCreateEntity(MyEntity3335Assoc entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3335AssocPickDTO> doUpdateEntity(MyEntity3335Assoc entity, MyEntity3335AssocPickDTO data,
																	   BusinessComponent bc) {
		setIfChanged(data, MyEntity3335AssocPickDTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyEntity3335AssocPickDTO_.customFieldText, entity::setCustomFieldText);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
package org.demo.documentation.widgets.assoctree.colortitle.colorconst;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.assoctree.colortitle.MyEntity3332Multi;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3332MultiPick0Service extends VersionAwareResponseService<MyEntity3332MultiPick0DTO, MyEntity3332Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3332MultiPick0Meta> meta = MyEntity3332MultiPick0Meta.class;

	@Override
	protected CreateResult<MyEntity3332MultiPick0DTO> doCreateEntity(MyEntity3332Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3332MultiPick0DTO> doUpdateEntity(MyEntity3332Multi entity, MyEntity3332MultiPick0DTO data,
																		BusinessComponent bc) {
		setIfChanged(data, MyEntity3332MultiPick0DTO_.customFieldText, entity::setCustomFieldText);
		return null;
	}


}
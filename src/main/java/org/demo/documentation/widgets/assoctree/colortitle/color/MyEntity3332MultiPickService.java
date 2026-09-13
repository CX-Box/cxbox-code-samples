package org.demo.documentation.widgets.assoctree.colortitle.color;

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
public class MyEntity3332MultiPickService extends VersionAwareResponseService<MyEntity3332MultiPickDTO, MyEntity3332Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3332MultiPickMeta> meta = MyEntity3332MultiPickMeta.class;

	@Override
	protected CreateResult<MyEntity3332MultiPickDTO> doCreateEntity(MyEntity3332Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3332MultiPickDTO> doUpdateEntity(MyEntity3332Multi entity, MyEntity3332MultiPickDTO data,
																	   BusinessComponent bc) {
		setIfChanged(data, MyEntity3332MultiPickDTO_.customFieldText, entity::setCustomFieldText);
		return null;
	}


}
package org.demo.documentation.widgets.property.excel.inner;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134SuggectionPick;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity3134SuggectionPickPickService extends VersionAwareResponseService<MyEntity3134SuggectionPickPickDTO, MyEntity3134SuggectionPick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3134SuggectionPickPickMeta> meta = MyEntity3134SuggectionPickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3134SuggectionPickPickDTO> doCreateEntity(MyEntity3134SuggectionPick entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3134SuggectionPickPickDTO> doUpdateEntity(MyEntity3134SuggectionPick entity, MyEntity3134SuggectionPickPickDTO data,
																				BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
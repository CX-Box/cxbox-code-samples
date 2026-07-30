package org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity3865MultiPick0Service extends VersionAwareResponseService<MyEntity3865MultiPick0DTO, org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3865MultiPick0Meta> meta = MyEntity3865MultiPick0Meta.class;

	@Override
	protected CreateResult<MyEntity3865MultiPick0DTO> doCreateEntity(org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3865MultiPick0DTO> doUpdateEntity(org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi entity, MyEntity3865MultiPick0DTO data,
	                                                                    BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
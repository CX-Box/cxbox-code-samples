package org.demo.documentation.widgets.tree.base.allType;

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
public class Myexample3262MultiPickService extends VersionAwareResponseService<Myexample3262MultiPickDTO, Myexample3262Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3262MultiPickMeta> meta = Myexample3262MultiPickMeta.class;

	@Override
	protected CreateResult<Myexample3262MultiPickDTO> doCreateEntity(Myexample3262Multi entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3262MultiPickDTO> doUpdateEntity(Myexample3262Multi entity, Myexample3262MultiPickDTO data,
	                                                                    BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
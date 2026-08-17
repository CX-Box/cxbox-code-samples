package org.demo.documentation.widgets.tree.allType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.tree.allType.Myexample3262MultiHoverPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class Myexample3262MultiHoverPickService extends VersionAwareResponseService<Myexample3262MultiHoverPickDTO, Myexample3262MultiHover> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3262MultiHoverPickMeta> meta = Myexample3262MultiHoverPickMeta.class;

	@Override
	protected CreateResult<Myexample3262MultiHoverPickDTO> doCreateEntity(Myexample3262MultiHover entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3262MultiHoverPickDTO> doUpdateEntity(Myexample3262MultiHover entity, Myexample3262MultiHoverPickDTO data,
	                                                                         BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
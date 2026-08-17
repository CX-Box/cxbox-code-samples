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
public class Myexample3262PickPickService extends VersionAwareResponseService<Myexample3262PickPickDTO, Myexample3262Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3262PickPickMeta> meta = Myexample3262PickPickMeta.class;

	@Override
	protected CreateResult<Myexample3262PickPickDTO> doCreateEntity(Myexample3262Pick entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3262PickPickDTO> doUpdateEntity(Myexample3262Pick entity, Myexample3262PickPickDTO data,
	                                                                   BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
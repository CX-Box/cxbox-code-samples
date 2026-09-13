package org.demo.documentation.widgets.tree.base.allType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class Myexample3262PickPick0Service extends VersionAwareResponseService<Myexample3262PickPick0DTO, Myexample3262Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3262PickPick0Meta> meta = Myexample3262PickPick0Meta.class;

	@Override
	protected CreateResult<Myexample3262PickPick0DTO> doCreateEntity(Myexample3262Pick entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3262PickPick0DTO> doUpdateEntity(Myexample3262Pick entity, Myexample3262PickPick0DTO data,
	                                                                    BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
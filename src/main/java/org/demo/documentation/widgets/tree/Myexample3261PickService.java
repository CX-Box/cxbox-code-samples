package org.demo.documentation.widgets.tree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.tree.tree.Myexample3261;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class Myexample3261PickService extends VersionAwareResponseService<Myexample3261PickDTO, Myexample3261> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261PickMeta> meta = Myexample3261PickMeta.class;

	@Override
	protected CreateResult<Myexample3261PickDTO> doCreateEntity(Myexample3261 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3261PickDTO> doUpdateEntity(Myexample3261 entity, Myexample3261PickDTO data,
	                                                                                                            BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
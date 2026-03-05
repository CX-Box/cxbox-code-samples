package org.demo.documentation.other.assoc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.other.assoc.MyEntity3421PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity3421PickService extends VersionAwareResponseService<MyEntity3421PickDTO, org.demo.documentation.other.drilldown.option.MyEntity3421> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3421PickMeta> meta = MyEntity3421PickMeta.class;

	@Override
	protected CreateResult<MyEntity3421PickDTO> doCreateEntity(org.demo.documentation.other.drilldown.option.MyEntity3421 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3421PickDTO> doUpdateEntity(org.demo.documentation.other.drilldown.option.MyEntity3421 entity, MyEntity3421PickDTO data,
																  BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
package org.demo.documentation.feature.drilldown.drilldownkey;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3627ChartService
		extends AnySourceVersionAwareResponseService<MyExample3627ChartDTO, MyExample3627ChartDTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3627ChartMeta> meta = MyExample3627ChartMeta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3627ChartDao> dao = MyExample3627ChartDao.class;

	@Override
	protected CreateResult<MyExample3627ChartDTO> doCreateEntity(MyExample3627ChartDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3627ChartDTO> doUpdateEntity(MyExample3627ChartDTO entity,
			MyExample3627ChartDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}

package org.demo.documentation.widgets.relationGraph.selectrecord;

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
public class MyExample6163Service extends AnySourceVersionAwareResponseService<MyExample6163DTO, MyExample6163DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6163Meta> meta = MyExample6163Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6163Dao> dao = MyExample6163Dao.class;

	@Override
	protected CreateResult<MyExample6163DTO> doCreateEntity(MyExample6163DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6163DTO> doUpdateEntity(MyExample6163DTO entity, MyExample6163DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

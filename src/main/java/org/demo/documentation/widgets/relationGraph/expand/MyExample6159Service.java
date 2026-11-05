package org.demo.documentation.widgets.relationGraph.expand;

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
public class MyExample6159Service extends AnySourceVersionAwareResponseService<MyExample6159DTO, MyExample6159DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6159Meta> meta = MyExample6159Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6159Dao> dao = MyExample6159Dao.class;

	@Override
	protected CreateResult<MyExample6159DTO> doCreateEntity(MyExample6159DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6159DTO> doUpdateEntity(MyExample6159DTO entity, MyExample6159DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

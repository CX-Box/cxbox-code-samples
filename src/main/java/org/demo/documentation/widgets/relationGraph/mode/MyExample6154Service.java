package org.demo.documentation.widgets.relationGraph.mode;

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
public class MyExample6154Service extends AnySourceVersionAwareResponseService<MyExample6154DTO, MyExample6154DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6154Meta> meta = MyExample6154Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6154Dao> dao = MyExample6154Dao.class;

	@Override
	protected CreateResult<MyExample6154DTO> doCreateEntity(MyExample6154DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6154DTO> doUpdateEntity(MyExample6154DTO entity, MyExample6154DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

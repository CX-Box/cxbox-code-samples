package org.demo.documentation.widgets.relationGraph.dragnode;

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
public class MyExample6162Service extends AnySourceVersionAwareResponseService<MyExample6162DTO, MyExample6162DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6162Meta> meta = MyExample6162Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6162Dao> dao = MyExample6162Dao.class;

	@Override
	protected CreateResult<MyExample6162DTO> doCreateEntity(MyExample6162DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6162DTO> doUpdateEntity(MyExample6162DTO entity, MyExample6162DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

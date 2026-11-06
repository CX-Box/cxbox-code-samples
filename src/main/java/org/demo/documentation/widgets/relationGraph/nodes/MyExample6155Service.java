package org.demo.documentation.widgets.relationGraph.nodes;

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
public class MyExample6155Service extends AnySourceVersionAwareResponseService<MyExample6155DTO, MyExample6155DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6155Meta> meta = MyExample6155Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6155Dao> dao = MyExample6155Dao.class;

	@Override
	protected CreateResult<MyExample6155DTO> doCreateEntity(MyExample6155DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6155DTO> doUpdateEntity(MyExample6155DTO entity, MyExample6155DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

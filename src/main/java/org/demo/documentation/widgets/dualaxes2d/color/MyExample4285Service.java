package org.demo.documentation.widgets.dualaxes2d.color;

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
public class MyExample4285Service extends AnySourceVersionAwareResponseService<MyExample4285DTO, MyExample4285DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4285Meta> meta = MyExample4285Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4285Dao> dao = MyExample4285Dao.class;

	@Override
	protected CreateResult<MyExample4285DTO> doCreateEntity(MyExample4285DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4285DTO> doUpdateEntity(MyExample4285DTO entity, MyExample4285DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

package org.demo.documentation.widgets.dualaxes2d.title;

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
public class MyExample4281Service extends AnySourceVersionAwareResponseService<MyExample4281DTO, MyExample4281DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4281Meta> meta = MyExample4281Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4281Dao> dao = MyExample4281Dao.class;

	@Override
	protected CreateResult<MyExample4281DTO> doCreateEntity(MyExample4281DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4281DTO> doUpdateEntity(MyExample4281DTO entity, MyExample4281DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

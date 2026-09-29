package org.demo.documentation.widgets.column2d.filtration;

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
public class MyExample4268Service extends AnySourceVersionAwareResponseService<MyExample4268DTO, MyExample4268DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4268Meta> meta = MyExample4268Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4268Dao> dao = MyExample4268Dao.class;

	@Override
	protected CreateResult<MyExample4268DTO> doCreateEntity(MyExample4268DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4268DTO> doUpdateEntity(MyExample4268DTO entity, MyExample4268DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}

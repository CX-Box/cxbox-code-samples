package org.demo.documentation.widgets.relationGraph.incorrectdata;

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
public class MyExample6160Service extends AnySourceVersionAwareResponseService<MyExample6160DTO, MyExample6160DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6160Meta> meta = MyExample6160Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6160Dao> dao = MyExample6160Dao.class;

	@Override
	protected CreateResult<MyExample6160DTO> doCreateEntity(MyExample6160DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6160DTO> doUpdateEntity(MyExample6160DTO entity, MyExample6160DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}

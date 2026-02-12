package org.demo.documentation.fields.suggestion.basic.microservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3080SuggestionService extends AnySourceVersionAwareResponseService<MyExample3080SuggestionDTO, MyEntity3080OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3080SuggestionMeta> meta = MyExample3080SuggestionMeta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3080Dao> dao = MyEntity3080Dao.class;


	@Override
	protected CreateResult<MyExample3080SuggestionDTO> doCreateEntity(MyEntity3080OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3080SuggestionDTO> doUpdateEntity(MyEntity3080OutServiceDTO entity, MyExample3080SuggestionDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3080SuggestionDTO> getActions() {
		return Actions.<MyExample3080SuggestionDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

	// --8<-- [end:getActions]
}
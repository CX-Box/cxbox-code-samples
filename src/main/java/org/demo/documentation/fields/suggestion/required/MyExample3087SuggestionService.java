package org.demo.documentation.fields.suggestion.required;

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
public class MyExample3087SuggestionService extends AnySourceVersionAwareResponseService<MyExample3087SuggestionDTO, MyEntity3087OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3087SuggestionMeta> meta = MyExample3087SuggestionMeta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3087Dao> dao = MyEntity3087Dao.class;


	@Override
	protected CreateResult<MyExample3087SuggestionDTO> doCreateEntity(MyEntity3087OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3087SuggestionDTO> doUpdateEntity(MyEntity3087OutServiceDTO entity, MyExample3087SuggestionDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3087SuggestionDTO> getActions() {
		return Actions.<MyExample3087SuggestionDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

	// --8<-- [end:getActions]
}
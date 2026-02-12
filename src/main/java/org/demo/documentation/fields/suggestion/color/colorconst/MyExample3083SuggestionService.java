package org.demo.documentation.fields.suggestion.color.colorconst;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyExample3083SuggestionService extends AnySourceVersionAwareResponseService<MyExample3083SuggestionDTO, MyEntity3083OutServiceDTO> {

	@lombok.Getter(onMethod_ = @Override)
	private final Class<MyEntity3083Dao> dao = MyEntity3083Dao.class;

	@Getter(onMethod_ = @Override)
	private final Class<? extends AnySourceFieldMetaBuilder<MyExample3083SuggestionDTO>> meta = MyExample3083SuggestionMeta.class;

	@Override
	protected CreateResult<MyExample3083SuggestionDTO> doCreateEntity(MyEntity3083OutServiceDTO entity,
																	  BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3083SuggestionDTO> doUpdateEntity(MyEntity3083OutServiceDTO entity,
																		 MyExample3083SuggestionDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3083SuggestionDTO> getActions() {
		return Actions.<MyExample3083SuggestionDTO>builder()
				.action(act -> act
						.action("save", "save")
				)
				.build();
	}

	// --8<-- [end:getActions]
}
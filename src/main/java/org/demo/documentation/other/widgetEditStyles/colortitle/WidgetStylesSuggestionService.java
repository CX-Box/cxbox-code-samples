package org.demo.documentation.other.widgetEditStyles.colortitle;

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
public class WidgetStylesSuggestionService extends AnySourceVersionAwareResponseService<WidgetStylesSuggestionDTO, WidgetStylesOutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<WidgetStylesSuggestionMeta> meta = WidgetStylesSuggestionMeta.class;
	@Getter(onMethod_ = @Override)
	private final Class<WidgetStylesDao> dao = WidgetStylesDao.class;


	@Override
	protected CreateResult<WidgetStylesSuggestionDTO> doCreateEntity(WidgetStylesOutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<WidgetStylesSuggestionDTO> doUpdateEntity(WidgetStylesOutServiceDTO entity, WidgetStylesSuggestionDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<WidgetStylesSuggestionDTO> getActions() {
		return Actions.<WidgetStylesSuggestionDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

	// --8<-- [end:getActions]
}
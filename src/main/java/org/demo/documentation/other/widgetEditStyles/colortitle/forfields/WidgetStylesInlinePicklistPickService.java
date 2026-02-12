package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class WidgetStylesInlinePicklistPickService extends VersionAwareResponseService<WidgetStylesInlinePicklistPickDTO, WidgetStylesInlinePicklist> {

	@Getter(onMethod_ = @Override)
	private final Class<WidgetStylesInlinePicklistPickMeta> meta = WidgetStylesInlinePicklistPickMeta.class;

	@Override
	protected CreateResult<WidgetStylesInlinePicklistPickDTO> doCreateEntity(WidgetStylesInlinePicklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<WidgetStylesInlinePicklistPickDTO> doUpdateEntity(WidgetStylesInlinePicklist entity, WidgetStylesInlinePicklistPickDTO data,
																				BusinessComponent bc) {
		return null;
	}


}
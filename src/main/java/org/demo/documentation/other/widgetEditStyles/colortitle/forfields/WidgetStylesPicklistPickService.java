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
public class WidgetStylesPicklistPickService extends VersionAwareResponseService<WidgetStylesPicklistPickDTO, WidgetStylesPicklist> {

	@Getter(onMethod_ = @Override)
	private final Class<WidgetStylesPicklistPickMeta> meta = WidgetStylesPicklistPickMeta.class;

	@Override
	protected CreateResult<WidgetStylesPicklistPickDTO> doCreateEntity(WidgetStylesPicklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<WidgetStylesPicklistPickDTO> doUpdateEntity(WidgetStylesPicklist entity, WidgetStylesPicklistPickDTO data,
																		  BusinessComponent bc) {
		return null;
	}


}
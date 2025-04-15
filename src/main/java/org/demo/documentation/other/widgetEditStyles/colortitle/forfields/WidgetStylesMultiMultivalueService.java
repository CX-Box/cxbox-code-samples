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
public class WidgetStylesMultiMultivalueService extends VersionAwareResponseService<WidgetStylesMultiMultivalueDTO, WidgetStylesMulti> {

    @Getter(onMethod_ = @Override)
    private final Class<WidgetStylesMultiMultivalueMeta> meta = WidgetStylesMultiMultivalueMeta.class;

    @Override
    protected CreateResult<WidgetStylesMultiMultivalueDTO> doCreateEntity(WidgetStylesMulti entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<WidgetStylesMultiMultivalueDTO> doUpdateEntity(WidgetStylesMulti entity, WidgetStylesMultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}
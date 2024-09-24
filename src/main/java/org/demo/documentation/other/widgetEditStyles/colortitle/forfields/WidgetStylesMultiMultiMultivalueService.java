package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class WidgetStylesMultiMultiMultivalueService extends VersionAwareResponseService<WidgetStylesMultiMultiMultivalueDTO, WidgetStylesMultiMulti> {

    public WidgetStylesMultiMultiMultivalueService() {
        super(WidgetStylesMultiMultiMultivalueDTO.class, WidgetStylesMultiMulti.class, null, WidgetStylesMultiMultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<WidgetStylesMultiMultiMultivalueDTO> doCreateEntity(WidgetStylesMultiMulti entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<WidgetStylesMultiMultiMultivalueDTO> doUpdateEntity(WidgetStylesMultiMulti entity, WidgetStylesMultiMultiMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}
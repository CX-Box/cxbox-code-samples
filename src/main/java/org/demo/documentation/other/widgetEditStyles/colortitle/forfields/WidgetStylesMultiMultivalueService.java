package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class WidgetStylesMultiMultivalueService extends VersionAwareResponseService<WidgetStylesMultiMultivalueDTO, WidgetStylesMulti> {

    public WidgetStylesMultiMultivalueService() {
        super(WidgetStylesMultiMultivalueDTO.class, WidgetStylesMulti.class, null, WidgetStylesMultiMultivalueMeta.class);
    }

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
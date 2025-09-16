package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.date.basic.DateBasic;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.list.actions.edit.withwidget.DateBasicPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class DateBasicPickService extends VersionAwareResponseService<DateBasicPickDTO, DateBasic> {

    @Getter(onMethod_ = @Override)
    private final Class<DateBasicPickMeta> meta = DateBasicPickMeta.class;

    @Override
    protected CreateResult<DateBasicPickDTO> doCreateEntity(DateBasic entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<DateBasicPickDTO> doUpdateEntity(DateBasic entity, DateBasicPickDTO data,
                                                               BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
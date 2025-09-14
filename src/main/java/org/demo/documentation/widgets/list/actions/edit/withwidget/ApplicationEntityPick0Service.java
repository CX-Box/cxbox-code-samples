package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.list.actions.edit.withwidget.ApplicationEntityPick0Meta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class ApplicationEntityPick0Service extends VersionAwareResponseService<ApplicationEntityPick0DTO, org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity> {

    @Getter(onMethod_ = @Override)
    private final Class<ApplicationEntityPick0Meta> meta = ApplicationEntityPick0Meta.class;

    @Override
    protected CreateResult<ApplicationEntityPick0DTO> doCreateEntity(org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<ApplicationEntityPick0DTO> doUpdateEntity(org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity entity, ApplicationEntityPick0DTO data,
                                                                        BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
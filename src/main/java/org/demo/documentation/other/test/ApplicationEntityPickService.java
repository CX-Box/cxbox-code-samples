package org.demo.documentation.other.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.other.test.ApplicationEntityPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class ApplicationEntityPickService extends VersionAwareResponseService<ApplicationEntityPickDTO, ApplicationEntity> {

    @Getter(onMethod_ = @Override)
    private final Class<ApplicationEntityPickMeta> meta = ApplicationEntityPickMeta.class;

    @Override
    protected CreateResult<ApplicationEntityPickDTO> doCreateEntity(ApplicationEntity entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<ApplicationEntityPickDTO> doUpdateEntity(ApplicationEntity entity, ApplicationEntityPickDTO data,
                                                                       BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
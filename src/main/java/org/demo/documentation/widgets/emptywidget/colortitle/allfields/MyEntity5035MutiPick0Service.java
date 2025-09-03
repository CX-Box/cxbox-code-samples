package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035MutiPick0Meta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5035MutiPick0Service extends VersionAwareResponseService<MyEntity5035MutiPick0DTO, MyEntity5035Muti> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5035MutiPick0Meta> meta = MyEntity5035MutiPick0Meta.class;

    @Override
    protected CreateResult<MyEntity5035MutiPick0DTO> doCreateEntity(MyEntity5035Muti entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5035MutiPick0DTO> doUpdateEntity(MyEntity5035Muti entity, MyEntity5035MutiPick0DTO data,
                                                                       BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
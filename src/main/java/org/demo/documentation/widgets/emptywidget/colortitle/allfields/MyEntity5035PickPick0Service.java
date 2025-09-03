package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035PickPick0Meta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5035PickPick0Service extends VersionAwareResponseService<MyEntity5035PickPick0DTO, MyEntity5035Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5035PickPick0Meta> meta = MyEntity5035PickPick0Meta.class;

    @Override
    protected CreateResult<MyEntity5035PickPick0DTO> doCreateEntity(MyEntity5035Pick entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5035PickPick0DTO> doUpdateEntity(MyEntity5035Pick entity, MyEntity5035PickPick0DTO data,
                                                                       BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
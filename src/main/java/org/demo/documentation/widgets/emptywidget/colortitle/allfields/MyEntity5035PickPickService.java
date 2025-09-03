package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035PickPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5035PickPickService extends VersionAwareResponseService<MyEntity5035PickPickDTO, MyEntity5035Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5035PickPickMeta> meta = MyEntity5035PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity5035PickPickDTO> doCreateEntity(MyEntity5035Pick entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5035PickPickDTO> doUpdateEntity(MyEntity5035Pick entity, MyEntity5035PickPickDTO data,
                                                                      BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
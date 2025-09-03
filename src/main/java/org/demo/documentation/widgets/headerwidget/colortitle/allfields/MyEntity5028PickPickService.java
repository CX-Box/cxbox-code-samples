package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.MyEntity5028PickPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5028PickPickService extends VersionAwareResponseService<MyEntity5028PickPickDTO, MyEntity5028Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5028PickPickMeta> meta = MyEntity5028PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity5028PickPickDTO> doCreateEntity(MyEntity5028Pick entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5028PickPickDTO> doUpdateEntity(MyEntity5028Pick entity, MyEntity5028PickPickDTO data,
                                                                      BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
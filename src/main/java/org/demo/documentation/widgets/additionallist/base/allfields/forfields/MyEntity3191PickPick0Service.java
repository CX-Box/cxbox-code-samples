package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3191PickPick0Service extends VersionAwareResponseService<MyEntity3191PickPick0DTO, MyEntity3191Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3191PickPick0Meta> meta = MyEntity3191PickPick0Meta.class;

    @Override
    protected CreateResult<MyEntity3191PickPick0DTO> doCreateEntity(MyEntity3191Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3191PickPick0DTO> doUpdateEntity(MyEntity3191Pick entity, MyEntity3191PickPick0DTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}
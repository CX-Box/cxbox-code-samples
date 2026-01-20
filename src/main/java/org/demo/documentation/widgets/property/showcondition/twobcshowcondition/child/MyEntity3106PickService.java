package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.list.showcondition.byparententity.child.MyEntity3106;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child.MyEntity3106PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity3106PickService extends VersionAwareResponseService<MyEntity3106PickDTO, MyEntity3106> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3106PickMeta> meta = MyEntity3106PickMeta.class;

    @Override
    protected CreateResult<MyEntity3106PickDTO> doCreateEntity(MyEntity3106 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3106PickDTO> doUpdateEntity(MyEntity3106 entity, MyEntity3106PickDTO data,
                                                                  BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
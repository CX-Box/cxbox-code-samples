package org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist;

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
public class MyEntity3618PickPickService extends VersionAwareResponseService<MyEntity3618PickPickDTO, MyEntity3618Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3618PickPickMeta> meta = MyEntity3618PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3618PickPickDTO> doCreateEntity(MyEntity3618Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3618PickPickDTO> doUpdateEntity(MyEntity3618Pick entity, MyEntity3618PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}
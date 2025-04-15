package org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist;

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
public class MyEntity3630PickService extends VersionAwareResponseService<MyEntity3630PickDTO, MyEntity3630> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3630PickMeta> meta = MyEntity3630PickMeta.class;

    @Override
    protected CreateResult<MyEntity3630PickDTO> doCreateEntity(MyEntity3630 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3630PickDTO> doUpdateEntity(MyEntity3630 entity, MyEntity3630PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}
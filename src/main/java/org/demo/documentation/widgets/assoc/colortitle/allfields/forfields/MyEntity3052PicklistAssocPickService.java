package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

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
public class MyEntity3052PicklistAssocPickService extends VersionAwareResponseService<MyEntity3052PicklistAssocPickDTO, MyEntity3052PicklistAssoc> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3052PicklistAssocPickMeta> meta = MyEntity3052PicklistAssocPickMeta.class;

    @Override
    protected CreateResult<MyEntity3052PicklistAssocPickDTO> doCreateEntity(MyEntity3052PicklistAssoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052PicklistAssocPickDTO> doUpdateEntity(MyEntity3052PicklistAssoc entity, MyEntity3052PicklistAssocPickDTO data,
                                                                               BusinessComponent bc) {
        return null;
    }


}
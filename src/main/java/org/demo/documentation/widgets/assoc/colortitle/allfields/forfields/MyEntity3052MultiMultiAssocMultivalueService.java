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
public class MyEntity3052MultiMultiAssocMultivalueService extends VersionAwareResponseService<MyEntity3052MultiMultiAssocMultivalueDTO, MyEntity3052MultiMultiAssoc> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3052MultiMultiAssocMultivalueMeta> meta = MyEntity3052MultiMultiAssocMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3052MultiMultiAssocMultivalueDTO> doCreateEntity(MyEntity3052MultiMultiAssoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052MultiMultiAssocMultivalueDTO> doUpdateEntity(MyEntity3052MultiMultiAssoc entity, MyEntity3052MultiMultiAssocMultivalueDTO data,
                                                                                       BusinessComponent bc) {
        return null;
    }


}
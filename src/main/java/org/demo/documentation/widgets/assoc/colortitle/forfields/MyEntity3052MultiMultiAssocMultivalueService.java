package org.demo.documentation.widgets.assoc.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3052MultiMultiAssocMultivalueService extends VersionAwareResponseService<MyEntity3052MultiMultiAssocMultivalueDTO, org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052MultiMultiAssoc> {

    public MyEntity3052MultiMultiAssocMultivalueService() {
        super(MyEntity3052MultiMultiAssocMultivalueDTO.class, org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052MultiMultiAssoc.class, null, MyEntity3052MultiMultiAssocMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3052MultiMultiAssocMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052MultiMultiAssoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052MultiMultiAssocMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052MultiMultiAssoc entity, MyEntity3052MultiMultiAssocMultivalueDTO data,
                                                                                       BusinessComponent bc) {
        return null;
    }


}
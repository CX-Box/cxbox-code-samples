package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3862AssocPickService extends VersionAwareResponseService<MyEntity3862AssocPickDTO, org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc> {

    public MyEntity3862AssocPickService() {
        super(MyEntity3862AssocPickDTO.class, org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc.class, null, MyEntity3862AssocPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3862AssocPickDTO> doCreateEntity(org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3862AssocPickDTO> doUpdateEntity(org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc entity, MyEntity3862AssocPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}
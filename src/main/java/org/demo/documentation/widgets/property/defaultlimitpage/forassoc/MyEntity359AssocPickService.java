package org.demo.documentation.widgets.property.defaultlimitpage.forassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity359AssocPickService extends VersionAwareResponseService<MyEntity359AssocPickDTO, MyEntity359Assoc> {

    public MyEntity359AssocPickService() {
        super(MyEntity359AssocPickDTO.class, MyEntity359Assoc.class, null, MyEntity359AssocPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity359AssocPickDTO> doCreateEntity(MyEntity359Assoc entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity359AssocPickDTO> doUpdateEntity(MyEntity359Assoc entity, MyEntity359AssocPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}
package org.demo.documentation.other.forceactive2.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4902PickInlinePickService extends VersionAwareResponseService<MyEntity4902PickInlinePickDTO, MyEntity4902PickInline> {

    public MyEntity4902PickInlinePickService() {
        super(MyEntity4902PickInlinePickDTO.class, MyEntity4902PickInline.class, null, MyEntity4902PickInlinePickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4902PickInlinePickDTO> doCreateEntity(MyEntity4902PickInline entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902PickInlinePickDTO> doUpdateEntity(MyEntity4902PickInline entity, MyEntity4902PickInlinePickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}
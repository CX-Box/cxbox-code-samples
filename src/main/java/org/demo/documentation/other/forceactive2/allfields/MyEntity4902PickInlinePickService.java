package org.demo.documentation.other.forceactive2.allfields;

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
public class MyEntity4902PickInlinePickService extends VersionAwareResponseService<MyEntity4902PickInlinePickDTO, MyEntity4902PickInline> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4902PickInlinePickMeta> meta = MyEntity4902PickInlinePickMeta.class;

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
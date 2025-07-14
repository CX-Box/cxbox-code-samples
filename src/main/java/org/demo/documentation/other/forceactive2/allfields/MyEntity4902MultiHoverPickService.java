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
public class MyEntity4902MultiHoverPickService extends VersionAwareResponseService<MyEntity4902MultiHoverPickDTO, MyEntity4902MultiHover> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4902MultiHoverPickMeta> meta = MyEntity4902MultiHoverPickMeta.class;

    @Override
    protected CreateResult<MyEntity4902MultiHoverPickDTO> doCreateEntity(MyEntity4902MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902MultiHoverPickDTO> doUpdateEntity(MyEntity4902MultiHover entity, MyEntity4902MultiHoverPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}
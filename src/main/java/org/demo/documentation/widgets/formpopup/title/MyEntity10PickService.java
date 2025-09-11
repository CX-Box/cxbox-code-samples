package org.demo.documentation.widgets.formpopup.title;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.percent.validationbusinessex.MyEntity10;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.formpopup.title.MyEntity10PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity10PickService extends VersionAwareResponseService<MyEntity10PickDTO, MyEntity10> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity10PickMeta> meta = MyEntity10PickMeta.class;

    @Override
    protected CreateResult<MyEntity10PickDTO> doCreateEntity(MyEntity10 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity10PickDTO> doUpdateEntity(MyEntity10 entity, MyEntity10PickDTO data,
                                                                BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
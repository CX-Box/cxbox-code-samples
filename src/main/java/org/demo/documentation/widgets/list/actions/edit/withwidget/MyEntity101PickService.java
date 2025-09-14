package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.fileupload.required.MyEntity101;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity101PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity101PickService extends VersionAwareResponseService<MyEntity101PickDTO, MyEntity101> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity101PickMeta> meta = MyEntity101PickMeta.class;

    @Override
    protected CreateResult<MyEntity101PickDTO> doCreateEntity(MyEntity101 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity101PickDTO> doUpdateEntity(MyEntity101 entity, MyEntity101PickDTO data,
                                                                 BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
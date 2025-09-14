package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.fileupload.sorting.MyEntity102;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity102PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity102PickService extends VersionAwareResponseService<MyEntity102PickDTO, MyEntity102> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity102PickMeta> meta = MyEntity102PickMeta.class;

    @Override
    protected CreateResult<MyEntity102PickDTO> doCreateEntity(MyEntity102 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity102PickDTO> doUpdateEntity(MyEntity102 entity, MyEntity102PickDTO data,
                                                                 BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
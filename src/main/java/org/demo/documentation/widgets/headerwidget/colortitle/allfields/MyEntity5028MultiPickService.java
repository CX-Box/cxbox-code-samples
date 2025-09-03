package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.MyEntity5028MultiPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5028MultiPickService extends VersionAwareResponseService<MyEntity5028MultiPickDTO, MyEntity5028Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5028MultiPickMeta> meta = MyEntity5028MultiPickMeta.class;

    @Override
    protected CreateResult<MyEntity5028MultiPickDTO> doCreateEntity(MyEntity5028Multi entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5028MultiPickDTO> doUpdateEntity(MyEntity5028Multi entity, MyEntity5028MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
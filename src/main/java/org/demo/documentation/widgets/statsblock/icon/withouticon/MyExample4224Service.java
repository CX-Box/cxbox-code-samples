package org.demo.documentation.widgets.statsblock.icon.withouticon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.statsblock.icon.withicon.MyExample4223DTO;
import org.demo.documentation.widgets.statsblock.icon.withicon.MyExample4223Dao;
import org.demo.documentation.widgets.statsblock.icon.withicon.MyExample4223Meta;
import org.springframework.stereotype.Service;

@SuppressWarnings({"EmptyMethod", "java:S1170"})
@RequiredArgsConstructor
@Service
public class MyExample4224Service extends AnySourceVersionAwareResponseService<MyExample4224DTO, MyExample4224DTO> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExample4224Meta> meta = MyExample4224Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4224Dao> dao = MyExample4224Dao.class;

    @Override
    protected CreateResult<MyExample4224DTO> doCreateEntity(MyExample4224DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4224DTO> doUpdateEntity(MyExample4224DTO entity, MyExample4224DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}

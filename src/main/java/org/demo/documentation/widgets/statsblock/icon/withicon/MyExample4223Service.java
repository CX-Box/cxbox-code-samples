package org.demo.documentation.widgets.statsblock.icon.withicon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample4223Service extends AnySourceVersionAwareResponseService<MyExample4223DTO, MyExample4223DTO> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExample4223Meta> meta = MyExample4223Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4223Dao> dao = MyExample4223Dao.class;

    @Override
    protected CreateResult<MyExample4223DTO> doCreateEntity(MyExample4223DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4223DTO> doUpdateEntity(MyExample4223DTO entity, MyExample4223DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}

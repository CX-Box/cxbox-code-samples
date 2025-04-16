package org.demo.documentation.widgets.statsblock.title.withouttitle;

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
public class MyExample4225Service extends AnySourceVersionAwareResponseService<MyExample4225DTO, MyExample4225DTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample4225Meta> meta = MyExample4225Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4225Dao> dao = MyExample4225Dao.class;

    @Override
    protected CreateResult<MyExample4225DTO> doCreateEntity(MyExample4225DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4225DTO> doUpdateEntity(MyExample4225DTO entity, MyExample4225DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}

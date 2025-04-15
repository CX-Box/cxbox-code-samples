package org.demo.documentation.widgets.statsblock.fieldslayoute;

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
public class MyExample4228Service extends AnySourceVersionAwareResponseService<MyExample4228DTO, MyExample4228DTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample4228Meta> meta = MyExample4228Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4228Dao> dao = MyExample4228Dao.class;

    @Override
    protected CreateResult<MyExample4228DTO> doCreateEntity(MyExample4228DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4228DTO> doUpdateEntity(MyExample4228DTO entity, MyExample4228DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}

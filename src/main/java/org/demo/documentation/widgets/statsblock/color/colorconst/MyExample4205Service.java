package org.demo.documentation.widgets.statsblock.color.colorconst;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;

import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample4205Service extends AnySourceVersionAwareResponseService<MyExample4205DTO, MyExample4205DTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample4205Meta> meta = MyExample4205Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4205Dao> dao = MyExample4205Dao.class;

    @Override
    protected CreateResult<MyExample4205DTO> doCreateEntity(MyExample4205DTO entity, BusinessComponent bc) {

        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4205DTO> doUpdateEntity(MyExample4205DTO entity, MyExample4205DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
}
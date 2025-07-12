package org.demo.documentation.getstarted.microservice.document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.getstarted.microservice.MyEntity4001OutServiceDTO;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample4003Service extends AnySourceVersionAwareResponseService<MyExample4003DTO, MyEntity4001OutServiceDTO> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4003Dao> dao = MyEntity4003Dao.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4003Meta> meta = MyExample4003Meta.class;

    @Override
    protected CreateResult<MyExample4003DTO> doCreateEntity(MyEntity4001OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4003DTO> doUpdateEntity(MyEntity4001OutServiceDTO entity, MyExample4003DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4003DTO> getActions() {
        return Actions.<MyExample4003DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}
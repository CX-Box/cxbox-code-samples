package org.demo.documentation.feature.microservice.old_createmicroservices;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
 import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3810Service extends AnySourceVersionAwareResponseService<MyExample3810DTO, MyEntity3810OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3810Meta> meta = MyExample3810Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3810Dao> dao = MyEntity3810Dao.class;

    @Override
    protected CreateResult<MyExample3810DTO> doCreateEntity(MyEntity3810OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3810DTO> doUpdateEntity(MyEntity3810OutServiceDTO entity, MyExample3810DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3810DTO> getActions() {
        return Actions.<MyExample3810DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}
package org.demo.documentation.getstarted.microservice.example;

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
public class MyExample4001Service extends AnySourceVersionAwareResponseService<MyExample4001DTO, MyEntity4001OutServiceDTO> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4001Dao> dao = MyEntity4001Dao.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4001Meta> meta = MyExample4001Meta.class;

    @Override
    protected CreateResult<MyExample4001DTO> doCreateEntity(MyEntity4001OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4001DTO> doUpdateEntity(MyEntity4001OutServiceDTO entity, MyExample4001DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4001DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4001DTO> getActions() {
        return Actions.<MyExample4001DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
package org.demo.documentation.widgets.statsblock.drilldown;

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
public class MyExample4210Service extends AnySourceVersionAwareResponseService<MyExample4210DTO, MyExample4210DTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample4210Meta> meta = MyExample4210Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4210Dao> dao = MyExample4210Dao.class;

    @Override
    protected CreateResult<MyExample4210DTO> doCreateEntity(MyExample4210DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4210DTO> doUpdateEntity(MyExample4210DTO entity, MyExample4210DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4210DTO> getActions() {
        return Actions.<MyExample4210DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
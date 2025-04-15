package org.demo.documentation.widgets.statsblock.color.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4204Service extends VersionAwareResponseService<MyExample4204DTO, MyEntity4204> {

    private final MyEntity4204Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4204Meta> meta = MyExample4204Meta.class;

    @Override
    protected CreateResult<MyExample4204DTO> doCreateEntity(MyEntity4204 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4204DTO> doUpdateEntity(MyEntity4204 entity, MyExample4204DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4204DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        if (data.isFieldChanged(MyExample4204DTO_.customFieldNum)) {
            entity.setCustomFieldNum(data.getCustomFieldNum());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4204DTO> getActions() {
        return Actions.<MyExample4204DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
package org.demo.documentation.navigation.tab.typestandard.businessexample.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3426Service extends VersionAwareResponseService<MyExample3426DTO, MyEntity3426> {

    private final MyEntity3426Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3426Meta> meta = MyExample3426Meta.class;

    @Override
    protected CreateResult<MyExample3426DTO> doCreateEntity(MyEntity3426 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3426DTO> doUpdateEntity(MyEntity3426 entity, MyExample3426DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3426DTO_.address, entity::setAddress);
        if (data.isFieldChanged(MyExample3426DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3426DTO> getActions() {
        return Actions.<MyExample3426DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}

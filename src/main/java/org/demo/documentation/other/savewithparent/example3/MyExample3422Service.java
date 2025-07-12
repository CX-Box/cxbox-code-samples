package org.demo.documentation.other.savewithparent.example3;

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
public class MyExample3422Service extends VersionAwareResponseService<MyExample3422DTO, MyEntity3422> {

    private final MyEntity3422Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3422Meta> meta = MyExample3422Meta.class;

    @Override
    protected CreateResult<MyExample3422DTO> doCreateEntity(MyEntity3422 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3422DTO> doUpdateEntity(MyEntity3422 entity, MyExample3422DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3422DTO_.customFieldDrilldown, entity::setCustomFieldDrilldown);
        if (data.isFieldChanged(MyExample3422DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3422DTO> getActions() {
        return Actions.<MyExample3422DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}

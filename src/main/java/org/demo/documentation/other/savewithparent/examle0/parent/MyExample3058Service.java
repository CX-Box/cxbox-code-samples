package org.demo.documentation.other.savewithparent.examle0.parent;

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
public class MyExample3058Service extends VersionAwareResponseService<MyExample3058DTO, MyEntity3058> {

    private final MyEntity3058Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3058Meta> meta = MyExample3058Meta.class;

    @Override
    protected CreateResult<MyExample3058DTO> doCreateEntity(MyEntity3058 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3058DTO> doUpdateEntity(MyEntity3058 entity, MyExample3058DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3058DTO_.customFieldRequired, entity::setCustomFieldRequired);
        if (data.isFieldChanged(MyExample3058DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3058DTO> getActions() {
        return Actions.<MyExample3058DTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }
    // --8<-- [end:getActions]

}


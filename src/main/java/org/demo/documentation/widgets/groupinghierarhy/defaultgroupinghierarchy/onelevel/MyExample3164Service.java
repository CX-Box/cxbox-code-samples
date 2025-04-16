package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel;

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
public class MyExample3164Service extends VersionAwareResponseService<MyExample3164DTO, MyEntity3164> {

    private final MyEntity3164Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3164Meta> meta = MyExample3164Meta.class;

    @Override
    protected CreateResult<MyExample3164DTO> doCreateEntity(MyEntity3164 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3164DTO> doUpdateEntity(MyEntity3164 entity, MyExample3164DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3164DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3164DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3164DTO> getActions() {
        return Actions.<MyExample3164DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


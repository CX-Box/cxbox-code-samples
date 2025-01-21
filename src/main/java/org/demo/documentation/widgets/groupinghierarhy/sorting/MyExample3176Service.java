package org.demo.documentation.widgets.groupinghierarhy.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3176Service extends VersionAwareResponseService<MyExample3176DTO, MyEntity3176> {

    private final MyEntity3176Repository repository;

    public MyExample3176Service(MyEntity3176Repository repository) {
        super(MyExample3176DTO.class, MyEntity3176.class, null, MyExample3176Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3176DTO> doCreateEntity(MyEntity3176 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3176DTO> doUpdateEntity(MyEntity3176 entity, MyExample3176DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3176DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3176DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3176DTO> getActions() {
        return Actions.<MyExample3176DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


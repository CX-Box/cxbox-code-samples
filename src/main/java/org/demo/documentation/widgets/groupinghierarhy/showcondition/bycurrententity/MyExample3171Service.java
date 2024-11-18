package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3171Service extends VersionAwareResponseService<MyExample3171DTO, MyEntity3171> {

    private final MyEntity3171Repository repository;

    public MyExample3171Service(MyEntity3171Repository repository) {
        super(MyExample3171DTO.class, MyEntity3171.class, null, MyExample3171Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3171DTO> doCreateEntity(MyEntity3171 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3171DTO> doUpdateEntity(MyEntity3171 entity, MyExample3171DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3171DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3171DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3171DTO> getActions() {
        return Actions.<MyExample3171DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


package org.demo.documentation.fields.time.baselocaltime;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3512Service extends VersionAwareResponseService<MyExample3512DTO, MyEntity3512> {

    private final MyEntity3512Repository repository;

    public MyExample3512Service(MyEntity3512Repository repository) {
        super(MyExample3512DTO.class, MyEntity3512.class, null, MyExample3512Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3512DTO> doCreateEntity(MyEntity3512 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3512DTO> doUpdateEntity(MyEntity3512 entity, MyExample3512DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3512DTO_.customFieldhmm, entity::setCustomFieldhmm);
        setIfChanged(data, MyExample3512DTO_.customFieldh, entity::setCustomFieldh);
        setIfChanged(data, MyExample3512DTO_.customFieldhmmssA, entity::setCustomFieldhmmssA);
        setIfChanged(data, MyExample3512DTO_.customFieldhmmA, entity::setCustomFieldhmmA);
        setIfChanged(data, MyExample3512DTO_.customFieldhA, entity::setCustomFieldhA);
        if (data.isFieldChanged(MyExample3512DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3512DTO> getActions() {
        return Actions.<MyExample3512DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


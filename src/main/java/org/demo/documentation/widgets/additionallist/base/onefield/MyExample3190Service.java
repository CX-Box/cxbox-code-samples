package org.demo.documentation.widgets.additionallist.base.onefield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3190Service extends VersionAwareResponseService<MyExample3190DTO, MyEntity3190> {

    private final MyEntity3190Repository repository;

    public MyExample3190Service(MyEntity3190Repository repository) {
        super(MyExample3190DTO.class, MyEntity3190.class, null, MyExample3190Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3190DTO> doCreateEntity(MyEntity3190 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3190DTO> doUpdateEntity(MyEntity3190 entity, MyExample3190DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3190DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3190DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3190DTO> getActions() {
        return Actions.<MyExample3190DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

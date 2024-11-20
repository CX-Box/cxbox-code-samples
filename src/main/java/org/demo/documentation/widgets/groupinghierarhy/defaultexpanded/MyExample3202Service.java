package org.demo.documentation.widgets.groupinghierarhy.defaultexpanded;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3202Service extends VersionAwareResponseService<MyExample3202DTO, MyEntity3202> {

    private final MyEntity3202Repository repository;

    public MyExample3202Service(MyEntity3202Repository repository) {
        super(MyExample3202DTO.class, MyEntity3202.class, null, MyExample3202Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3202DTO> doCreateEntity(MyEntity3202 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3202DTO> doUpdateEntity(MyEntity3202 entity, MyExample3202DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3202DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3202DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3202DTO> getActions() {
        return Actions.<MyExample3202DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


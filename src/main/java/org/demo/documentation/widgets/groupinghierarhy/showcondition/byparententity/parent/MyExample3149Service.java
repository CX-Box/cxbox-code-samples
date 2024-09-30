package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3149Service extends VersionAwareResponseService<MyExample3149DTO, MyEntity3149> {

    private final MyEntity3149Repository repository;

    public MyExample3149Service(MyEntity3149Repository repository) {
        super(MyExample3149DTO.class, MyEntity3149.class, null, MyExample3149Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3149DTO> doCreateEntity(MyEntity3149 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3149DTO> doUpdateEntity(MyEntity3149 entity, MyExample3149DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3149DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3149DTO> getActions() {
        return Actions.<MyExample3149DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}


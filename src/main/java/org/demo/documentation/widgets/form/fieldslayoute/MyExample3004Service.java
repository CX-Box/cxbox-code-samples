package org.demo.documentation.widgets.form.fieldslayoute;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.form.title.MyExample3003DTO_;
import org.springframework.stereotype.Service;


@Service
public class MyExample3004Service extends VersionAwareResponseService<MyExample3004DTO, MyEntity3004> {

    private final MyEntity3004Repository repository;

    public MyExample3004Service(MyEntity3004Repository repository) {
        super(MyExample3004DTO.class, MyEntity3004.class, null, MyExample3004Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3004DTO> doCreateEntity(MyEntity3004 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3004DTO> doUpdateEntity(MyEntity3004 entity, MyExample3004DTO data,
                                                               BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3004DTO_.customField7)) {
            entity.setCustomField7(data.getCustomField7());
        }
        if (data.isFieldChanged(MyExample3004DTO_.customField6)) {
            entity.setCustomField6(data.getCustomField6());
        }
        if (data.isFieldChanged(MyExample3004DTO_.customField5)) {
            entity.setCustomField5(data.getCustomField5());
        }
        if (data.isFieldChanged(MyExample3004DTO_.customField4)) {
            entity.setCustomField4(data.getCustomField4());
        }
        if (data.isFieldChanged(MyExample3004DTO_.customField3)) {
            entity.setCustomField3(data.getCustomField3());
        }
        if (data.isFieldChanged(MyExample3004DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }
        if (data.isFieldChanged(MyExample3003DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3004DTO> getActions() {
        return Actions.<MyExample3004DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
    // --8<-- [end:getActions]

}
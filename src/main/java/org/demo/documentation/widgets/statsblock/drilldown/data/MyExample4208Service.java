package org.demo.documentation.widgets.statsblock.drilldown.data;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4208Service extends VersionAwareResponseService<MyExample4208DTO, MyEntity4208> {

    private final MyEntity4208Repository repository;

    public MyExample4208Service(MyEntity4208Repository repository) {
        super(MyExample4208DTO.class, MyEntity4208.class, null, MyExample4208Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4208DTO> doCreateEntity(MyEntity4208 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4208DTO> doUpdateEntity(MyEntity4208 entity, MyExample4208DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4208DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4208DTO> getActions() {
        return Actions.<MyExample4208DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}
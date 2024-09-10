package org.demo.documentation.navigation.tab.typestandard.businessexample;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3422Service extends VersionAwareResponseService<MyExample3422DTO, MyEntity3422> {

    private final MyEntity3422Repository repository;

    public MyExample3422Service(MyEntity3422Repository repository) {
        super(MyExample3422DTO.class, MyEntity3422.class, null, MyExample3422Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3422DTO> doCreateEntity(MyEntity3422 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3422DTO> doUpdateEntity(MyEntity3422 entity, MyExample3422DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3422DTO_.customFieldDrilldown, entity::setCustomFieldDrilldown);
        if (data.isFieldChanged(MyExample3422DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3422DTO> getActions() {
        return Actions.<MyExample3422DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }


}


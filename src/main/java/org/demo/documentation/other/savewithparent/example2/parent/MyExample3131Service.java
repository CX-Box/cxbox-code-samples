package org.demo.documentation.other.savewithparent.example2.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.savewithparent.example2.child.MyEntity3130;
import org.demo.documentation.other.savewithparent.example2.child.MyEntity3130Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyExample3131Service extends VersionAwareResponseService<MyExample3131DTO, MyEntity3131> {

    private final MyEntity3131Repository repository;
    private final MyEntity3130Repository repositoryChild;

    public MyExample3131Service(MyEntity3131Repository repository, MyEntity3130Repository repositoryChild) {
        super(MyExample3131DTO.class, MyEntity3131.class, null, MyExample3131Meta.class);
        this.repository = repository;
        this.repositoryChild = repositoryChild;
    }

    @Override
    protected CreateResult<MyExample3131DTO> doCreateEntity(MyEntity3131 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3131DTO> doUpdateEntity(MyEntity3131 entity, MyExample3131DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3131DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3131DTO> getActions() {
        return Actions.<MyExample3131DTO>builder()
                .save().text("Save").add()
                .build();
    }


}


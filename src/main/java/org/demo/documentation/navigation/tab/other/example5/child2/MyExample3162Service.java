package org.demo.documentation.navigation.tab.other.example5.child2;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;
import org.demo.documentation.navigation.tab.other.example5.child3.MyExample3163DTO;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161Repository;
import org.springframework.stereotype.Service;

@Service
public class MyExample3162Service extends VersionAwareResponseService<MyExample3162DTO, MyEntity3162> {

    private final MyEntity3162Repository repository;
    private final MyEntity3161Repository repositoryParent;

    public MyExample3162Service(MyEntity3162Repository repository, MyEntity3161Repository repositoryParent) {
        super(MyExample3162DTO.class, MyEntity3162.class, null, MyExample3162Meta.class);
        this.repository = repository;
        this.repositoryParent = repositoryParent;
    }

    @Override
    protected CreateResult<MyExample3162DTO> doCreateEntity(MyEntity3162 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3162DTO> doUpdateEntity(MyEntity3162 entity, MyExample3162DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3162DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3162DTO> getActions() {
        return Actions.<MyExample3162DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .action("refreshParent", "refresh Parent bc")
                .invoker(this::customSaveInvoker)
                .add()
                .build();
    }

    private ActionResultDTO<MyExample3162DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3162DTO dto) {
        MyEntity3161 parentEntity = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        parentEntity.setCustomField("Test data" +  Math.random());
        repositoryParent.save(parentEntity);
        return new ActionResultDTO<>(dto).setAction(PostAction.refreshBc(CxboxMyExample3160Controller.myexample3161));
    }


}

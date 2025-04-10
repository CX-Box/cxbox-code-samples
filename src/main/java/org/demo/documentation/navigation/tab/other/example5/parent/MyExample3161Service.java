package org.demo.documentation.navigation.tab.other.example5.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3161Service extends VersionAwareResponseService<MyExample3161DTO, MyEntity3161> {

    private final MyEntity3161Repository repository;

    public MyExample3161Service(MyEntity3161Repository repository) {
        super(MyExample3161DTO.class, MyEntity3161.class, null, MyExample3161Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3161DTO> doCreateEntity(MyEntity3161 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3161DTO> doUpdateEntity(MyEntity3161 entity, MyExample3161DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3161DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3161DTO> getActions() {
        return Actions.<MyExample3161DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .action(act -> act
                        .action("refreshParent", "refresh Parent bc")
                        .invoker(this::customSaveInvoker)
                )
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:customSaveInvoker]
    private ActionResultDTO<MyExample3161DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3161DTO dto) {
        MyEntity3161 entity = repository.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomField("Test data" +  Math.random());
         return new ActionResultDTO<>(dto).setAction(PostAction.refreshBc(CxboxMyExample3160Controller.myexample3161));
    }
    // --8<-- [end:customSaveInvoker]


}


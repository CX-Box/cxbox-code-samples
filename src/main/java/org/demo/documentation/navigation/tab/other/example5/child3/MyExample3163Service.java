package org.demo.documentation.navigation.tab.other.example5.child3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161Repository;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3163Service extends VersionAwareResponseService<MyExample3163DTO, MyEntity3163> {

    private final MyEntity3163Repository repository;
    private final MyEntity3161Repository repositoryParent;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3163Meta> meta = MyExample3163Meta.class;

    @Override
    protected CreateResult<MyExample3163DTO> doCreateEntity(MyEntity3163 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3163DTO> doUpdateEntity(MyEntity3163 entity, MyExample3163DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3163DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3163DTO> getActions() {
        return Actions.<MyExample3163DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .action(act -> act
                        .action("refreshParent", "refresh Parent bc")
                        .invoker(this::customSaveInvoker)
                )
                .build();
    }

    private ActionResultDTO<MyExample3163DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3163DTO dto) {
        MyEntity3161 parentEntity = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        parentEntity.setCustomField("Test data" +  Math.random());
        repositoryParent.save(parentEntity);
        return new ActionResultDTO<>(dto).setAction(PostAction.refreshBc(CxboxMyExample3160Controller.myexample3161));
    }


}


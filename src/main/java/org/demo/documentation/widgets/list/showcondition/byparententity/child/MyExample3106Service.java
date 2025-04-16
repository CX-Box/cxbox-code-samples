package org.demo.documentation.widgets.list.showcondition.byparententity.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.list.showcondition.byparententity.PlatformMyExample3100Controller;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyEntity3100;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyEntity3100Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3106Service extends VersionAwareResponseService<MyExample3106DTO, MyEntity3106> {

    private final MyEntity3106Repository repository;

    private final MyEntity3100Repository repositoryParent;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3106Meta> meta = MyExample3106Meta.class;

    @Override
    protected Specification<MyEntity3106> getParentSpecification(BusinessComponent bc) {

        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3106_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3106DTO> doCreateEntity(MyEntity3106 entity, BusinessComponent bc) {
        MyEntity3100 myEntity3100 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomFieldEntity(myEntity3100);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3106DTO> doUpdateEntity(MyEntity3106 entity, MyExample3106DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3106DTO_.customField, entity::setCustomField);

        return new ActionResultDTO<>(entityToDto(bc, entity)).setAction(
                PostAction.refreshBc(PlatformMyExample3100Controller.myexample3100
                ));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3106DTO> getActions() {
        return Actions.<MyExample3106DTO>builder()
                .action(act -> act.action("save", "save")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3106DTO>().setAction(
                                    PostAction.refreshBc(PlatformMyExample3100Controller.myexample3100
                                    ));
                        }))
                        .create(crt -> crt)
                        .delete(dlt -> dlt)
                        .build();
    }
    // --8<-- [end:getActions]
}
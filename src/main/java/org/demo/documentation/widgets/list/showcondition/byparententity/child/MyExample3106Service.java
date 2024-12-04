package org.demo.documentation.widgets.list.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.feature.drilldown.goingbackafterdrilldown.MyExample3620DTO;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;
import org.demo.documentation.widgets.info.showcondition.byparententity.child.MyEntity3107;
import org.demo.documentation.widgets.info.showcondition.byparententity.child.MyEntity3107_;
import org.demo.documentation.widgets.list.showcondition.byparententity.PlatformMyExample3100Controller;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class MyExample3106Service extends VersionAwareResponseService<MyExample3106DTO, MyEntity3106> {

    private final MyEntity3106Repository repository;

    public MyExample3106Service(MyEntity3106Repository repository) {
        super(MyExample3106DTO.class, MyEntity3106.class, null, MyExample3106Meta.class);
        this.repository = repository;
    }

    @Override
    protected Specification<MyEntity3106> getParentSpecification(BusinessComponent bc) {

        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3106_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3106DTO> doCreateEntity(MyEntity3106 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3106DTO> doUpdateEntity(MyEntity3106 entity, MyExample3106DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3106DTO_.customField, entity::setCustomField);

        return new ActionResultDTO<>(entityToDto(bc, entity));
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
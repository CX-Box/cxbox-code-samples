package org.demo.documentation.widgets.form.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyEntity3007;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyEntity3007Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class MyExample3006Service extends VersionAwareResponseService<MyExample3006DTO, MyEntity3006> {

    private final MyEntity3006Repository repository;

    private final MyEntity3007Repository repositoryParent;

    public MyExample3006Service(MyEntity3006Repository repository, MyEntity3007Repository repositoryParent) {
        super(MyExample3006DTO.class, MyEntity3006.class, null, MyExample3006Meta.class);
        this.repository = repository;
        this.repositoryParent = repositoryParent;
    }

    @Override
    protected Specification<MyEntity3006> getParentSpecification(BusinessComponent bc) {

        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3006_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3006DTO> doCreateEntity(MyEntity3006 entity, BusinessComponent bc) {
        MyEntity3007 myEntity3007 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomFieldEntity(myEntity3007);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3006DTO> doUpdateEntity(MyEntity3006 entity, MyExample3006DTO data,
                                                               BusinessComponent bc) {

        if (data.isFieldChanged(MyExample3006DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3006DTO> getActions() {
        return Actions.<MyExample3006DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}
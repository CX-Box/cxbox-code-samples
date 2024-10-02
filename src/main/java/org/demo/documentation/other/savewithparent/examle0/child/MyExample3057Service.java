package org.demo.documentation.other.savewithparent.examle0.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;

import org.demo.documentation.other.savewithparent.examle0.parent.MyEntity3058;
import org.demo.documentation.other.savewithparent.examle0.parent.MyEntity3058Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MyExample3057Service extends VersionAwareResponseService<MyExample3057DTO, MyEntity3057> {

    private final MyEntity3057Repository repository;

    private final MyEntity3058Repository repositoryParent;

    public MyExample3057Service(MyEntity3057Repository repository, MyEntity3058Repository repositoryParent) {
        super(MyExample3057DTO.class, MyEntity3057.class, null, MyExample3057Meta.class);
        this.repository = repository;
        this.repositoryParent = repositoryParent;
    }
    @Override
    protected Specification<MyEntity3057> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3057_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }

    @Override
    protected CreateResult<MyExample3057DTO> doCreateEntity(MyEntity3057 entity, BusinessComponent bc) {
        MyEntity3058 myEntityParent = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomFieldEntity(myEntityParent);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3057DTO> doUpdateEntity(MyEntity3057 entity, MyExample3057DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3057DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3057DTO> getActions() {
        return Actions.<MyExample3057DTO>builder()
                .action("addChild", "Add")
                .invoker((bc, dto) -> {
                    MyEntity3058 myEntityParent = repositoryParent.getById(bc.getParentIdAsLong());
                    repositoryParent.save(myEntityParent);
                    return new ActionResultDTO<MyExample3057DTO>() ;
                })
                .add()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }
    // --8<-- [end:getActions]

}


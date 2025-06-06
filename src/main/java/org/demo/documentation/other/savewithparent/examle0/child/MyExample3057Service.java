package org.demo.documentation.other.savewithparent.examle0.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
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

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3057Service extends VersionAwareResponseService<MyExample3057DTO, MyEntity3057> {

    private final MyEntity3057Repository repository;

    private final MyEntity3058Repository repositoryParent;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3057Meta> meta = MyExample3057Meta.class;

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
                .action(act -> act
                        .action("addChild", "Add")
                        .invoker((bc, dto) -> {
                            MyEntity3058 myEntityParent = repositoryParent.getReferenceById(bc.getParentIdAsLong());
                            repositoryParent.save(myEntityParent);
                            return new ActionResultDTO<MyExample3057DTO>();
                        })
                )
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}


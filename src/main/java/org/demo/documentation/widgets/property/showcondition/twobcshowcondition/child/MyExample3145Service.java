package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent.MyEntity3146;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent.MyEntity3146Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3145Service extends VersionAwareResponseService<MyExample3145DTO, MyEntity3145> {

    private final MyEntity3145Repository repository;
    private final MyEntity3146Repository repositoryParent;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3145Meta> meta = MyExample3145Meta.class;

    @Override
    protected Specification<MyEntity3145> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3145_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }

    @Override
    protected CreateResult<MyExample3145DTO> doCreateEntity(MyEntity3145 entity, BusinessComponent bc) {
        MyEntity3146 myEntity3146= repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomFieldEntity(myEntity3146);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3145DTO> doUpdateEntity(MyEntity3145 entity, MyExample3145DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3145DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3145DTO> getActions() {
        return Actions.<MyExample3145DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}

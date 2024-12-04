package org.demo.documentation.widgets.info.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class MyExample3107Service extends VersionAwareResponseService<MyExample3107DTO, MyEntity3107> {

    private final MyEntity3107Repository repository;

    public MyExample3107Service(MyEntity3107Repository repository) {
        super(MyExample3107DTO.class, MyEntity3107.class, null, MyExample3107Meta.class);
        this.repository = repository;
    }

    @Override
    protected Specification<MyEntity3107> getParentSpecification(BusinessComponent bc) {

        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3107_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }

    @Override
    protected CreateResult<MyExample3107DTO> doCreateEntity(MyEntity3107 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3107DTO> doUpdateEntity(MyEntity3107 entity, MyExample3107DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3107DTO> getActions() {
        return Actions.<MyExample3107DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
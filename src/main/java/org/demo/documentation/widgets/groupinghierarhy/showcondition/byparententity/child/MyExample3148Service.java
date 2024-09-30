package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MyExample3148Service extends VersionAwareResponseService<MyExample3148DTO, MyEntity3148> {

    private final MyEntity3148Repository repository;

    public MyExample3148Service(MyEntity3148Repository repository) {
        super(MyExample3148DTO.class, MyEntity3148.class, null, MyExample3148Meta.class);
        this.repository = repository;
    }
    @Override
    protected Specification<MyEntity3148> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3148_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3148DTO> doCreateEntity(MyEntity3148 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3148DTO> doUpdateEntity(MyEntity3148 entity, MyExample3148DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3148DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3148DTO> getActions() {
        return Actions.<MyExample3148DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}


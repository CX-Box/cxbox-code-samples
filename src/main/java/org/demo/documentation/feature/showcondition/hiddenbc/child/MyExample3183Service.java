package org.demo.documentation.feature.showcondition.hiddenbc.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MyExample3183Service extends VersionAwareResponseService<MyExample3183DTO, MyEntity3183> {

    private final MyEntity3183Repository repository;

    public MyExample3183Service(MyEntity3183Repository repository) {
        super(MyExample3183DTO.class, MyEntity3183.class, null, MyExample3183Meta.class);
        this.repository = repository;
    }
    @Override
    protected Specification<MyEntity3183> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3183_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3183DTO> doCreateEntity(MyEntity3183 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3183DTO> doUpdateEntity(MyEntity3183 entity, MyExample3183DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3183DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3183DTO> getActions() {
        return Actions.<MyExample3183DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

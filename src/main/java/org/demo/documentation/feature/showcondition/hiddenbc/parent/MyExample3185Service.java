package org.demo.documentation.feature.showcondition.hiddenbc.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3185Service extends VersionAwareResponseService<MyExample3185DTO, MyEntity3185> {

    private final MyEntity3185Repository repository;

    public MyExample3185Service(MyEntity3185Repository repository) {
        super(MyExample3185DTO.class, MyEntity3185.class, null, MyExample3185Meta.class);
        this.repository = repository;
    }

    @Override
    protected Specification<MyEntity3185> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3185_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }

    @Override
    protected CreateResult<MyExample3185DTO> doCreateEntity(MyEntity3185 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3185DTO> doUpdateEntity(MyEntity3185 entity, MyExample3185DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3185DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        if (data.isFieldChanged(MyExample3185DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3185DTO> getActions() {
        return Actions.<MyExample3185DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}


package org.demo.documentation.other.savewithparent.example2.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3130Service extends VersionAwareResponseService<MyExample3130DTO, MyEntity3130> {

    private final MyEntity3130Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3130Meta> meta = MyExample3130Meta.class;

    @Override
    protected Specification<MyEntity3130> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3130_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3130DTO> doCreateEntity(MyEntity3130 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3130DTO> doUpdateEntity(MyEntity3130 entity, MyExample3130DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3130DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3130DTO> getActions() {
        return Actions.<MyExample3130DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }


}


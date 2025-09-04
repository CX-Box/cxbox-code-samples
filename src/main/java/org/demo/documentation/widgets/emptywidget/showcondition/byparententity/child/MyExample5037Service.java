package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child;

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

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5037Service extends VersionAwareResponseService<MyExample5037DTO, MyEntity5037> {

    private final MyEntity5037Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5037Meta> meta = MyExample5037Meta.class;

    @Override
    protected CreateResult<MyExample5037DTO> doCreateEntity(MyEntity5037 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected Specification<MyEntity5037> getParentSpecification(BusinessComponent bc) {

        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity5037_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected ActionResultDTO<MyExample5037DTO> doUpdateEntity(MyEntity5037 entity, MyExample5037DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5037DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5037DTO> getActions() {
        return Actions.<MyExample5037DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}
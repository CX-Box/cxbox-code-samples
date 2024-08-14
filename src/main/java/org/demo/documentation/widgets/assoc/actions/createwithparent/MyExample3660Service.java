package org.demo.documentation.widgets.assoc.actions.createwithparent;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3661;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3661Repository;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3662;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3663;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3660Service extends VersionAwareResponseService<MyExample3660DTO, MyEntity3660> {

    private final MyEntity3660Repository repository;
    private final MyEntity3661Repository repositoryParent;

    @Autowired
    private EntityManager entityManager;

    public MyExample3660Service(MyEntity3660Repository repository, MyEntity3661Repository repositoryParent) {
        super(MyExample3660DTO.class, MyEntity3660.class, null, MyExample3660Meta.class);
        this.repository = repository;
        this.repositoryParent = repositoryParent;
    }

    @Override
    protected Specification<MyEntity3660> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3660_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }

    @Override
    protected CreateResult<MyExample3660DTO> doCreateEntity(MyEntity3660 entity, BusinessComponent bc) {
        MyEntity3661 myEntity3661 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomFieldEntity(myEntity3661);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3660DTO> doUpdateEntity(MyEntity3660 entity, MyExample3660DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3660DTO_.customFieldReq)) {
            entity.getCustomFieldReqList().clear();
            entity.getCustomFieldReqList().addAll(data.getCustomFieldReq().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3663.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample3660DTO_.customFieldTextReq, entity::setCustomFieldTextReq);
        setIfChanged(data, MyExample3660DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3660DTO_.customField)) {
            entity.getCustomFieldList().clear();
            entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3662.class, e))
                    .collect(Collectors.toList()));
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3660DTO> getActions() {
        return Actions.<MyExample3660DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }


}


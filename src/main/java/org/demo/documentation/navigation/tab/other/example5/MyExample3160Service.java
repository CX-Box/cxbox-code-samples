package org.demo.documentation.navigation.tab.other.example5;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161Repository;
import org.demo.documentation.other.savewithparent.examle0.parent.MyEntity3058;
import org.demo.documentation.other.savewithparent.example2.child.MyEntity3130;
import org.demo.documentation.other.savewithparent.example2.child.MyEntity3130_;
import org.demo.documentation.other.savewithparent.example443.child.MyExample3077DTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MyExample3160Service extends VersionAwareResponseService<MyExample3160DTO, MyEntity3160> {

    private final MyEntity3160Repository repository;

    private final MyEntity3161Repository repositoryParent;

    public MyExample3160Service(MyEntity3160Repository repository, MyEntity3161Repository repositoryParent) {
        super(MyExample3160DTO.class, MyEntity3160.class, null, MyExample3160Meta.class);
        this.repository = repository;
        this.repositoryParent = repositoryParent;
    }
    @Override
    protected Specification<MyEntity3160> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3160_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }
    @Override
    protected CreateResult<MyExample3160DTO> doCreateEntity(MyEntity3160 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3160DTO> doUpdateEntity(MyEntity3160 entity, MyExample3160DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3160DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3160DTO> getActions() {
        return Actions.<MyExample3160DTO>builder()
                .action("refreshParent", "refresh Parent bc")
                .invoker(this::customSaveInvoker)
                .add()

                .build();
    }

    private ActionResultDTO<MyExample3160DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3160DTO dto) {
        MyEntity3161 parentEntity = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        parentEntity.setCustomField("Test data" +  Math.random());
        repositoryParent.save(parentEntity);
         return new ActionResultDTO<>(dto).setAction(PostAction.refreshBc(CxboxMyExample3160Controller.myexample3161));
    }

}


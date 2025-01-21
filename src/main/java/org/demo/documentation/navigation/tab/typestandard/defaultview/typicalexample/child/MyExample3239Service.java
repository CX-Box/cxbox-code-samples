package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.CxboxMyExample3238Controller;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.MyEntity3238;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.MyEntity3238Repository;
import org.demo.documentation.widgets.list.actions.create.newview.CxboxMyExample3066Controller;
import org.demo.documentation.widgets.list.actions.create.newview.MyEntity3066;
import org.demo.documentation.widgets.list.actions.create.newview.MyExample3066DTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3239Service extends VersionAwareResponseService<MyExample3239DTO, MyEntity3239> {

    private final MyEntity3239Repository repository;

    private final MyEntity3238Repository repositoryParent;

    public MyExample3239Service(MyEntity3239Repository repository, MyEntity3238Repository repositoryParent) {
        super(MyExample3239DTO.class, MyEntity3239.class, null, MyExample3239Meta.class);
        this.repository = repository;
        this.repositoryParent = repositoryParent;
    }

    @Override
    protected Specification<MyEntity3239> getParentSpecification(BusinessComponent bc) {
        return (root, cq, cb) -> cb.and(
                super.getParentSpecification(bc).toPredicate(root, cq, cb),
                cb.equal(root.get(MyEntity3239_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
        );
    }

    @Override
    protected CreateResult<MyExample3239DTO> doCreateEntity(MyEntity3239 entity, BusinessComponent bc) {
        MyEntity3238 myEntity = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
        entity.setCustomFieldEntity(myEntity);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3238/view/myexample3239form/"
                                + CxboxMyExample3238Controller.myexample3238 + "/"
                                + entity.getCustomFieldEntity().getId()+ "/"
                                + CxboxMyExample3238Controller.myexample3239 + "/"
                                + entity.getId()));
    }

    @Override
    protected ActionResultDTO<MyExample3239DTO> doUpdateEntity(MyEntity3239 entity, MyExample3239DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3239DTO_.phoneNumber, entity::setPhoneNumber);
        setIfChanged(data, MyExample3239DTO_.fullName, entity::setFullName);
        if (data.isFieldChanged(MyExample3239DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3239DTO> getActions() {
        return Actions.<MyExample3239DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(act ->
                        act.invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3239DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3238/view/myexample3238form/" + CxboxMyExample3238Controller.myexample3238 + "/"+  bc.getParentId()
                                    ));
                        })
                )
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("finish", "Save and Close")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3239DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3238/view/myexample3238form/" + CxboxMyExample3238Controller.myexample3238 + "/" +  bc.getParentId()
                                    ));
                        })
                )
                .build();
    }


}


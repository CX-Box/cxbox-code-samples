package org.demo.documentation.navigation.tab.other.example5.child4;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.navigation.tab.other.example5.CxboxMyExample3160Controller;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163;
import org.demo.documentation.navigation.tab.other.example5.child3.MyEntity3163Repository;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161;
import org.demo.documentation.navigation.tab.other.example5.parent.MyEntity3161Repository;
import org.springframework.stereotype.Service;

@Service
public class MyExample3165Service extends VersionAwareResponseService<MyExample3165DTO, MyEntity3165> {

    private final MyEntity3165Repository repository;
    private final MyEntity3163Repository repository3163;

    public MyExample3165Service(MyEntity3165Repository repository, MyEntity3163Repository repository3163) {
        super(MyExample3165DTO.class, MyEntity3165.class, null, MyExample3165Meta.class);
        this.repository = repository;
        this.repository3163 = repository3163;

    }

    @Override
    protected CreateResult<MyExample3165DTO> doCreateEntity(MyEntity3165 entity, BusinessComponent bc) {
        repository.save(entity);
        MyEntity3163 entity3163 = repository3163.findById(bc.getParentIdAsLong()).orElse(null);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3160/view/myexample3160for11/" + CxboxMyExample3160Controller.myexample3161 + "/"
                                + entity3163.getCustomFieldEntity().getId() + "/"
                                + CxboxMyExample3160Controller.myexample3163 + "/"
                                + bc.getParentIdAsLong() + "/"
                                + CxboxMyExample3160Controller.myexample3165 + "/"
                                + entity.getId()));
    }

    @Override
    protected ActionResultDTO<MyExample3165DTO> doUpdateEntity(MyEntity3165 entity, MyExample3165DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3165DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3165DTO> getActions() {
        return Actions.<MyExample3165DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}


package org.demo.documentation.other.savewithparent.example443.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.savewithparent.example443.child.MyExample3077DTO;
import org.demo.documentation.other.savewithparent.example443.child.MyExample3077DTO_;
import org.demo.documentation.widgets.list.actions.create.newview.CxboxMyExample3066Controller;
import org.springframework.stereotype.Service;


@Service
public class MyExample3076Service extends AnySourceVersionAwareResponseService<MyExample3076DTO, MyEntity3076OutServiceDTO> {


    public MyExample3076Service() {
        super(MyExample3076DTO.class, MyEntity3076OutServiceDTO.class, MyExample3076Meta.class, MyEntity3076Dao.class);
    }


    @Override
    protected CreateResult<MyExample3076DTO> doCreateEntity(MyEntity3076OutServiceDTO entity, BusinessComponent bc) {
        return  new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3076/view/myexample3076/"
                                + CxboxMyExample3076Controller.myexample3076+ "/"
                                + entity.getId()));
    }

    @Override
    protected ActionResultDTO<MyExample3076DTO> doUpdateEntity(MyEntity3076OutServiceDTO entity, MyExample3076DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3076DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample3076DTO_.customFieldNew)) {
            entity.setCustomFieldNew(data.getCustomFieldNew());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3076DTO> getActions() {
        return Actions.<MyExample3076DTO>builder()
                .create().text("Add parent").withAutoSaveBefore()
                .add()

                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .build();
    }

}
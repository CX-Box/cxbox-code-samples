package org.demo.documentation.widgets.assoc.actions.createwithparent;

import lombok.Getter;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3662MultivalueService extends VersionAwareResponseService<MyEntity3662MultivalueDTO, org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3662> {

    public MyEntity3662MultivalueService() {
        super(MyEntity3662MultivalueDTO.class, org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3662.class, null, MyEntity3662MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3662MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3662 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3662MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3662 entity, MyEntity3662MultivalueDTO data,
                                                                        BusinessComponent bc) {
        setIfChanged(data, MyEntity3662MultivalueDTO_.customFieldText, entity::setCustomFieldText);
        return null;
    }

    @Override
    public Actions<MyEntity3662MultivalueDTO> getActions() {
        return Actions.<MyEntity3662MultivalueDTO>builder()
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
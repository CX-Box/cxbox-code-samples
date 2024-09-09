package org.demo.documentation.other.savewithparent.example443.child;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3077Service extends AnySourceVersionAwareResponseService<MyExample3077DTO, MyEntity3077OutServiceDTO> {


    public MyExample3077Service() {
        super(MyExample3077DTO.class, MyEntity3077OutServiceDTO.class, MyExample3077Meta.class, MyEntity3077Dao.class);
    }

    @Override
    protected CreateResult<MyExample3077DTO> doCreateEntity(MyEntity3077OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc,  entity.setParentId(String.valueOf(bc.getParentIdAsLong()))));
    }

    @Override
    protected ActionResultDTO<MyExample3077DTO> doUpdateEntity(MyEntity3077OutServiceDTO entity, MyExample3077DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3077DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3077DTO> getActions() {
        return Actions.<MyExample3077DTO>builder()
                .create().text("Add child").withAutoSaveBefore()
                .add()

                .action("customSave", "Custom Save")
                .invoker(this::customSaveInvoker)
                .add()

                .action("cancel", "Cancel")
                .invoker((bc, dto) -> {
                    return new ActionResultDTO<MyExample3077DTO>().setAction(
                            PostAction.drillDown(
                                    DrillDownType.INNER,
                                    "/screen/myexample3076"
                            ));
                })
                .withoutAutoSaveBefore()
                .add()
                .build();
    }

    private ActionResultDTO<MyExample3077DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3077DTO dto) {
        this.getBaseDao().flush(bc);
        return new ActionResultDTO<>(dto).setAction(PostAction.refreshBc(bc));
    }

}
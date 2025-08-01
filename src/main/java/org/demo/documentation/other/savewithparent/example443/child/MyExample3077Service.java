package org.demo.documentation.other.savewithparent.example443.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3077Service extends AnySourceVersionAwareResponseService<MyExample3077DTO, MyEntity3077OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3077Meta> meta = MyExample3077Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3077Dao> dao = MyEntity3077Dao.class;

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

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3077DTO> getActions() {
        return Actions.<MyExample3077DTO>builder()
                .create(crt -> crt.text("Add child").withAutoSaveBefore()
                )
                .cancelCreate(ccr -> ccr.text("Cancel"))
                .action(act -> act

                        .action("customSave", "Custom Save")
                        .invoker(this::customSaveInvoker)
                )
                .action(act -> act

                        .action("cancel", "Cancel")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3077DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3076"
                                    ));
                        })
                        .withoutAutoSaveBefore()
                )
                .build();
    }
    // --8<-- [end:getActions]
    // --8<-- [start:customSaveInvoker]
    private ActionResultDTO<MyExample3077DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3077DTO dto) {
        this.getBaseDao().flush(bc);
        return new ActionResultDTO<>(dto).setAction(PostAction.refreshBc(bc));
    }
    // --8<-- [end:customSaveInvoker]
}
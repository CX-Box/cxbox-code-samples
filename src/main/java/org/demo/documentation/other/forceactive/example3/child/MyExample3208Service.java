package org.demo.documentation.other.forceactive.example3.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.forceactive.example3.CxboxMyExample3207Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3208Service extends VersionAwareResponseService<MyExample3208DTO, MyEntity3208> {

    private final MyEntity3208Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3208Meta> meta = MyExample3208Meta.class;

    @Override
    protected CreateResult<MyExample3208DTO> doCreateEntity(MyEntity3208 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity))
                .setAction(PostAction.drillDown(
                        DrillDownType.INNER,
                        "/screen/myexample3207/view/myexample3208form/"
                                + CxboxMyExample3207Controller.myexample3207 + "/"
                                + bc.getParentIdAsLong() + "/"
                                + CxboxMyExample3207Controller.myexample3208 + "/"
                                + entity.getId()));
    }

    @Override
    protected ActionResultDTO<MyExample3208DTO> doUpdateEntity(MyEntity3208 entity, MyExample3208DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3208DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3208DTO> getActions() {
        return Actions.<MyExample3208DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("goto", "Goto And Save")
                        .scope(ActionScope.RECORD)
                        .withAutoSaveBefore()
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3208DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3207/view/myexample3207form"
                                    ));
                        })
                ).build();
    }


}


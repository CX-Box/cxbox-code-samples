package org.demo.documentation.widgets.property.excel.postAction.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170" )
@Service
@RequiredArgsConstructor
public class MyExample6500PostActionExportToExcelListService extends VersionAwareResponseService<MyExample6500PostActionExportToExcelListDTO, MyExample6500PostActionExportToExcelListEntity> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExample6500PostActionExportToExcelListMeta> meta = MyExample6500PostActionExportToExcelListMeta.class;

    @Override
    protected CreateResult<MyExample6500PostActionExportToExcelListDTO> doCreateEntity(final MyExample6500PostActionExportToExcelListEntity entity, final BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyExample6500PostActionExportToExcelListDTO> doUpdateEntity(final MyExample6500PostActionExportToExcelListEntity entity, final MyExample6500PostActionExportToExcelListDTO data,
                                                                                          final BusinessComponent bc) {
        return null;
    }

    @Override
    public Actions<MyExample6500PostActionExportToExcelListDTO> getActions() {
        return Actions.<MyExample6500PostActionExportToExcelListDTO>builder()
                .action(act -> act
                        .scope(ActionScope.BC)
                        .withPreAction(PreAction.confirm(cf -> cf.text("Export to Excel?" )))
                        .action("customExportToExcel", "Custom export to excel" )
                        .invoker((bc, data) -> new ActionResultDTO<MyExample6500PostActionExportToExcelListDTO>().setAction(PostAction.exportToExcel()))
                )
                .build();
    }
}


package org.demo.documentation.other.drilldown.option.forfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.drilldown.PlatformDrilldownService;
import org.demo.documentation.other.drilldown.option.CxboxMyExample3421Controller;
import org.springframework.stereotype.Service;



@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3424ForFilterService extends AnySourceVersionAwareResponseService<MyExample3424ForFilterDTO, MyExample3424ForFilterDTO> {

    private final PlatformDrilldownService platformDrilldownService;

    @Getter(onMethod_ = @Override)
    private final Class<MyExample3424ForFilterMeta> meta = MyExample3424ForFilterMeta.class;

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3424ForFilterDao> dao = MyEntity3424ForFilterDao.class;


    @Override
    protected CreateResult<MyExample3424ForFilterDTO> doCreateEntity(MyExample3424ForFilterDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3424ForFilterDTO> doUpdateEntity(MyExample3424ForFilterDTO entity, MyExample3424ForFilterDTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3424ForFilterDTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3424ForFilterDTO> getActions() {
        return Actions.<MyExample3424ForFilterDTO>builder()
                .action(act -> act
                        .action("finish", "Save and Finish")
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample3424ForFilterDTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample3421/view/myexample3421list"
                                    ));
                        })
                )
                .action(act -> act
                        .action("findOut", "Find CustomField")
                        .invoker((bc, dto) -> new ActionResultDTO<MyExample3424ForFilterDTO>().setAction(
																PostAction.drillDownWithFilter(
                                    DrillDownType.INNER,
																		"/screen/myexample3421/view/myexample3421form",
                                    fc -> fc
                                        .add(CxboxMyExample3421Controller.myexample3424, MyExample3424ForFilterDTO.class, fb -> fb
                                            .input(MyExample3424ForFilterDTO_.customField, dto.getCustomField())
                                        )
																)))
                )
                .build();
    }


}
package org.demo.documentation.widgets.property.excel.any;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3136Service extends AnySourceVersionAwareResponseService<MyExample3136DTO, MyEntity3136OutServiceDTO> {


    @Getter(onMethod_ = @Override)
    private final Class<MyExample3136Meta> meta = MyExample3136Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3136Dao> dao = MyEntity3136Dao.class;


    @Override
    protected CreateResult<MyExample3136DTO> doCreateEntity(MyEntity3136OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3136DTO> doUpdateEntity(MyEntity3136OutServiceDTO entity, MyExample3136DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3136DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        if (data.isFieldChanged(MyExample3136DTO_.customFieldDateTime)) {
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3136DTO> getActions() {
        return Actions.<MyExample3136DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }

    // --8<-- [end:getActions]
}
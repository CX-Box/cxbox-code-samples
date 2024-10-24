package org.demo.documentation.other.anysource;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.existingmicroservices.MyExample3800DTO_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.demo.documentation.fields.main.TextError.LESS_CURRENT_DATE;
import static org.demo.documentation.fields.main.TextError.MORE_CURRENT_DATE;


@Service
public class MyExample3420Service extends AnySourceVersionAwareResponseService<MyExample3420DTO, MyEntity3420OutServiceDTO> {


    public MyExample3420Service() {
        super(MyExample3420DTO.class, MyEntity3420OutServiceDTO.class, MyExample3420Meta.class, MyEntity3420Dao.class);
    }


    @Override
    protected CreateResult<MyExample3420DTO> doCreateEntity(MyEntity3420OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3420DTO> doUpdateEntity(MyEntity3420OutServiceDTO entity, MyExample3420DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3420DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample3420DTO_.customFieldNew)) {
            entity.setCustomFieldNew(data.getCustomFieldNew());
        }
        if (data.isFieldChanged(MyExample3420DTO_.customFieldDateTime)) {
            LocalDateTime sysdate = LocalDateTime.now();
            if (data.getCustomFieldDateTime() != null && sysdate.compareTo(data.getCustomFieldDateTime()) < 0) {
                throw new BusinessException().addPopup(MORE_CURRENT_DATE);
            }
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }
        if (data.isFieldChanged(MyExample3420DTO_.customFieldDouble)) {
            entity.setCustomFieldDouble(data.getCustomFieldDouble());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3420DTO> getActions() {
        return Actions.<MyExample3420DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt.text("Add"))
                .delete(dlt -> dlt)
                .build();
    }

     // --8<-- [end:getActions]  
}
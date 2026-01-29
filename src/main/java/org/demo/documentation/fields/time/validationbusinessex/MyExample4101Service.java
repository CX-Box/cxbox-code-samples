package org.demo.documentation.fields.time.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;

import static org.demo.documentation.fields.main.TextError.MORE_CURRENT_TIME;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4101Service extends VersionAwareResponseService<MyExample4101DTO, MyEntity4101> {

    private final MyEntity4101Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4101Meta> meta = MyExample4101Meta.class;

    @Override
    protected CreateResult<MyExample4101DTO> doCreateEntity(MyEntity4101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample4101DTO> doUpdateEntity(MyEntity4101 entity, MyExample4101DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4101DTO_.customField)) {
            LocalTime fieldTime = data.getCustomField()
                    .atZone(ZoneId.systemDefault())
                    .toLocalTime();

            LocalTime currentTime = LocalTime.now();

            if (currentTime.isBefore(fieldTime)) {
                            throw new BusinessException().addPopup(MORE_CURRENT_TIME);
            }
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]
    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample4101DTO> getActions() {
        return Actions.<MyExample4101DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}
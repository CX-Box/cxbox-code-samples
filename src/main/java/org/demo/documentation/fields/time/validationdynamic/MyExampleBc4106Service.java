package org.demo.documentation.fields.time.validationdynamic;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;

import static org.demo.documentation.fields.main.TextError.MORE_CURRENT_TIME;

@Service
@Getter
@RequiredArgsConstructor
public class MyExampleBc4106Service extends VersionAwareResponseService<MyExampleBc4106DTO, MyExampleBc4106> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExampleBc4106MetaBuilder> meta = MyExampleBc4106MetaBuilder.class;

    private final MyExampleBc4106Repository myExampleBc4106Repository;


    @Override
    protected Specification<MyExampleBc4106> getSpecification(BusinessComponent bc) {
        return super.getSpecification(bc);
    }

    @Override
    protected CreateResult<MyExampleBc4106DTO> doCreateEntity(MyExampleBc4106 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, myExampleBc4106Repository.save(entity)));
    }

    @Override
    protected ActionResultDTO<MyExampleBc4106DTO> doUpdateEntity(MyExampleBc4106 entity, MyExampleBc4106DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExampleBc4106DTO_.customFieldAdditional, entity::setCustomFieldAdditional);
        setIfChanged(data, MyExampleBc4106DTO_.customField, entity::setCustomField);
        validateFields(bc, data);
        return new ActionResultDTO<>(entityToDto(bc, myExampleBc4106Repository.save(entity)))
                .setAction(PostAction.refreshBc(bc));
    }

    @Override
    public Actions<MyExampleBc4106DTO> getActions() {
        return Actions.<MyExampleBc4106DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }

    // --8<-- [start:validateFields]
    private void validateFields(BusinessComponent bc, MyExampleBc4106DTO dto) {
        BusinessError.Entity entity = new BusinessError.Entity(bc);
        LocalTime fieldTime = dto.getCustomField()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();

        LocalTime fieldTimeAdditional = dto.getCustomFieldAdditional()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();

        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(fieldTime)) {
            entity.addField(MyExampleBc4106DTO_.customField.getName(), "Custom message about error");
        }
        if (currentTime.isBefore(fieldTimeAdditional)) {
            entity.addField(MyExampleBc4106DTO_.customFieldAdditional.getName(), "Custom message about error");
        }
        if (!entity.getFields().isEmpty()) {
            throw new BusinessException().setEntity(entity);
        }
    }
    // --8<-- [end:validateFields]

}

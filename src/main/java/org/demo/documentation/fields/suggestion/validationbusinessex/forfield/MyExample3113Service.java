package org.demo.documentation.fields.suggestion.validationbusinessex.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3113Service extends VersionAwareResponseService<MyExample3113DTO, MyEntity3113> {

    private final MyEntity3113Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3113Meta> meta = MyExample3113Meta.class;

    @Override
    protected CreateResult<MyExample3113DTO> doCreateEntity(MyEntity3113 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3113DTO> doUpdateEntity(MyEntity3113 entity, MyExample3113DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3113DTO_.customField)) {
        entity.setCustomField(data.getCustomField());
        if (StringUtils.isNotEmpty(data.getCustomField())
                && !String.valueOf(data.getCustomField()).matches("[A-Za-z]+")
        ) {
          throw new BusinessException().addPopup(ONLY_LETTER);
        }
      }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3113DTO> getActions() {
        return Actions.<MyExample3113DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}

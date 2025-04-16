package org.demo.documentation.fields.suggestion.sorting.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3122Service extends VersionAwareResponseService<MyExample3122DTO, MyEntity3122> {

    private final MyEntity3122Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3122Meta> meta = MyExample3122Meta.class;

    @Override
    protected CreateResult<MyExample3122DTO> doCreateEntity(MyEntity3122 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3122DTO> doUpdateEntity(MyEntity3122 entity, MyExample3122DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3122DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3122DTO> getActions() {
        return Actions.<MyExample3122DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


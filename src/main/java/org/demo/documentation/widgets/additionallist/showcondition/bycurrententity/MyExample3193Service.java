package org.demo.documentation.widgets.additionallist.showcondition.bycurrententity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3193Service extends VersionAwareResponseService<MyExample3193DTO, MyEntity3193> {

    private final MyEntity3193Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3193Meta> meta = MyExample3193Meta.class;

    @Override
    protected CreateResult<MyExample3193DTO> doCreateEntity(MyEntity3193 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3193DTO> doUpdateEntity(MyEntity3193 entity, MyExample3193DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3193DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3193DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3193DTO> getActions() {
        return Actions.<MyExample3193DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


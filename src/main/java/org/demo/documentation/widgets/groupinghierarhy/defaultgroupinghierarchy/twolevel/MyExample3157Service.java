package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel;

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
public class MyExample3157Service extends VersionAwareResponseService<MyExample3157DTO, MyEntity3157> {

    private final MyEntity3157Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3157Meta> meta = MyExample3157Meta.class;

    @Override
    protected CreateResult<MyExample3157DTO> doCreateEntity(MyEntity3157 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3157DTO> doUpdateEntity(MyEntity3157 entity, MyExample3157DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3157DTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
        setIfChanged(data, MyExample3157DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3157DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3157DTO> getActions() {
        return Actions.<MyExample3157DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

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
public class MyExample3165Service extends VersionAwareResponseService<MyExample3165DTO, MyEntity3165> {

    private final MyEntity3165Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3165Meta> meta = MyExample3165Meta.class;

    @Override
    protected CreateResult<MyExample3165DTO> doCreateEntity(MyEntity3165 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3165DTO> doUpdateEntity(MyEntity3165 entity, MyExample3165DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3165DTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
        setIfChanged(data, MyExample3165DTO_.customFieldDictionaryLevelThree, entity::setCustomFieldDictionaryLevelThree);
        setIfChanged(data, MyExample3165DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3165DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3165DTO> getActions() {
        return Actions.<MyExample3165DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


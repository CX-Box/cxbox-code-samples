package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel;

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
public class MyExample3158Service extends VersionAwareResponseService<MyExample3158DTO, MyEntity3158> {

    private final MyEntity3158Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3158Meta> meta = MyExample3158Meta.class;

    @Override
    protected CreateResult<MyExample3158DTO> doCreateEntity(MyEntity3158 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3158DTO> doUpdateEntity(MyEntity3158 entity, MyExample3158DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3158DTO_.customFieldDictionaryLevelFive, entity::setCustomFieldDictionaryLevelFive);
        setIfChanged(data, MyExample3158DTO_.customFieldDictionaryLevelFour, entity::setCustomFieldDictionaryLevelFour);
        setIfChanged(data, MyExample3158DTO_.customFieldDictionaryLevelThree, entity::setCustomFieldDictionaryLevelThree);
        setIfChanged(data, MyExample3158DTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
        setIfChanged(data, MyExample3158DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3158DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3158DTO> getActions() {
        return Actions.<MyExample3158DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


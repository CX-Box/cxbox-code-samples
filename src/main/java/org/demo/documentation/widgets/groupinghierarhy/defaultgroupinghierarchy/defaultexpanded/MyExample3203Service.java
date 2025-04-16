package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded;

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
public class MyExample3203Service extends VersionAwareResponseService<MyExample3203DTO, MyEntity3203> {

    private final MyEntity3203Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3203Meta> meta = MyExample3203Meta.class;

    @Override
    protected CreateResult<MyExample3203DTO> doCreateEntity(MyEntity3203 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3203DTO> doUpdateEntity(MyEntity3203 entity, MyExample3203DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3203DTO_.customFieldDictionaryLevelThree, entity::setCustomFieldDictionaryLevelThree);
        setIfChanged(data, MyExample3203DTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
        setIfChanged(data, MyExample3203DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3203DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3203DTO> getActions() {
        return Actions.<MyExample3203DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


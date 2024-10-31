package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3155Service extends VersionAwareResponseService<MyExample3155DTO, MyEntity3155> {

    private final MyEntity3155Repository repository;

    public MyExample3155Service(MyEntity3155Repository repository) {
        super(MyExample3155DTO.class, MyEntity3155.class, null, MyExample3155Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3155DTO> doCreateEntity(MyEntity3155 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3155DTO> doUpdateEntity(MyEntity3155 entity, MyExample3155DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3155DTO_.customFieldDictionaryLevelFour, entity::setCustomFieldDictionaryLevelFour);
        setIfChanged(data, MyExample3155DTO_.customFieldDictionaryLevelThree, entity::setCustomFieldDictionaryLevelThree);
        setIfChanged(data, MyExample3155DTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
        setIfChanged(data, MyExample3155DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3155DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3155DTO> getActions() {
        return Actions.<MyExample3155DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


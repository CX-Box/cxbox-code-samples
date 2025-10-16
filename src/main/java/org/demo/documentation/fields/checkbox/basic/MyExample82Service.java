package org.demo.documentation.fields.checkbox.basic;

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
public class MyExample82Service extends VersionAwareResponseService<MyExample82DTO, MyEntity82> {

    private final MyEntity82Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample82Meta> meta = MyExample82Meta.class;

    @Override
    protected CreateResult<MyExample82DTO> doCreateEntity(MyEntity82 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample82DTO> doUpdateEntity(MyEntity82 entity, MyExample82DTO data,
                                                             BusinessComponent bc) {
        setIfChanged(data, MyExample82DTO_.customField11, entity::setCustomField11);
        setIfChanged(data, MyExample82DTO_.customField10, entity::setCustomField10);
        setIfChanged(data, MyExample82DTO_.customField9, entity::setCustomField9);
        setIfChanged(data, MyExample82DTO_.customField8, entity::setCustomField8);
        setIfChanged(data, MyExample82DTO_.customField7, entity::setCustomField7);
        setIfChanged(data, MyExample82DTO_.customField3, entity::setCustomField3);
        setIfChanged(data, MyExample82DTO_.customField2, entity::setCustomField2);
        setIfChanged(data, MyExample82DTO_.customField6, entity::setCustomField6);
        setIfChanged(data, MyExample82DTO_.customField4, entity::setCustomField4);
        setIfChanged(data, MyExample82DTO_.customField5, entity::setCustomField5);
        setIfChanged(data, MyExample82DTO_.dsgfsg, entity::setDsgfsg);
        if (data.isFieldChanged(MyExample82DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample82DTO> getActions() {
        return Actions.<MyExample82DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]

}
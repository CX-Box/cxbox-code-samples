package org.demo.documentation.fields.dictionary.dictionarylov.old.basic;

import
        static org.demo.documentation.fields.dictionary.dictionarylov.old.AdministeredDictionaryTypeOld.REGIONS;

import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample350Service extends VersionAwareResponseService<MyExample350DTO, MyEntity350> {

    private final MyEntity350Repository repository;


    public MyExample350Service(MyEntity350Repository repository) {
        super(MyExample350DTO.class, MyEntity350.class, null, MyExample350Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample350DTO> doCreateEntity(MyEntity350 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample350DTO> doUpdateEntity(MyEntity350 entity, MyExample350DTO data,
                                                              BusinessComponent bc) {
        setMappedIfChanged(data, MyExample350DTO_.customField, entity::setCustomField, val -> {
            if (StringUtils.isNotBlank(val)) {
                return REGIONS.lookupName(val);
            } else {
                return null;
            }
        });
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample350DTO> getActions() {
        return Actions.<MyExample350DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}
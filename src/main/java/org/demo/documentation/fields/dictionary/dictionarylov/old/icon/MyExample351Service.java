package org.demo.documentation.fields.dictionary.dictionarylov.old.icon;

import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.dictionary.dictionarylov.old.AdministeredDictionaryTypeOld.REGIONS;

@Service
public class MyExample351Service extends VersionAwareResponseService<MyExample351DTO, MyEntity351> {

    private final MyEntity351Repository repository;

    public MyExample351Service(MyEntity351Repository repository) {
        super(MyExample351DTO.class, MyEntity351.class, null, MyExample351Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample351DTO> doCreateEntity(MyEntity351 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample351DTO> doUpdateEntity(MyEntity351 entity, MyExample351DTO data, BusinessComponent bc) {

        setMappedIfChanged(data, MyExample351DTO_.customFieldDictionary, entity::setCustomFieldDictionary, val -> {
            if (StringUtils.isNotBlank(val)) {
                return REGIONS.lookupName(val);
            } else {
                return null;
            }
        });
        if (data.isFieldChanged(MyExample351DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample351DTO> getActions() {
        return Actions.<MyExample351DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


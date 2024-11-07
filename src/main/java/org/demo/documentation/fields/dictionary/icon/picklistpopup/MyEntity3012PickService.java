package org.demo.documentation.fields.dictionary.icon.picklistpopup;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

@Getter
@Service
public class MyEntity3012PickService extends VersionAwareResponseService<MyEntity3012PickDTO, MyEntity3012> {

    public MyEntity3012PickService() {
        super(MyEntity3012PickDTO.class, MyEntity3012.class, null, MyEntity3012PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3012PickDTO> doCreateEntity(MyEntity3012 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3012PickDTO> doUpdateEntity(MyEntity3012 entity, MyEntity3012PickDTO data,
                                                                  BusinessComponent bc) {
        setIfChanged(data, MyEntity3012PickDTO_.customField, entity::setCustomField);
        setIfChanged(data, MyEntity3012PickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

}
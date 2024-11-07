package org.demo.documentation.fields.dictionary.icon.assoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3012MultiPickService extends VersionAwareResponseService<MyEntity3012MultiPickDTO, org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi> {

    public MyEntity3012MultiPickService() {
        super(MyEntity3012MultiPickDTO.class, org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi.class, null, MyEntity3012MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3012MultiPickDTO> doCreateEntity(org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3012MultiPickDTO> doUpdateEntity(org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi entity, MyEntity3012MultiPickDTO data,
                                                                       BusinessComponent bc) {
        setIfChanged(data, MyEntity3012MultiPickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
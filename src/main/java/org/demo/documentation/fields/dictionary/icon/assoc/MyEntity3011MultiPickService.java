package org.demo.documentation.fields.dictionary.icon.assoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3011MultiPickService extends VersionAwareResponseService<MyEntity3011MultiPickDTO, org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi> {

    public MyEntity3011MultiPickService() {
        super(MyEntity3011MultiPickDTO.class, org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi.class, null, MyEntity3011MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3011MultiPickDTO> doCreateEntity(org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3011MultiPickDTO> doUpdateEntity(org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi entity, MyEntity3011MultiPickDTO data,
                                                                       BusinessComponent bc) {
        setIfChanged(data, MyEntity3011MultiPickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
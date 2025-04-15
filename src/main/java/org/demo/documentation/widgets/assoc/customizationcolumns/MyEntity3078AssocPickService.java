package org.demo.documentation.widgets.assoc.customizationcolumns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3078AssocPickService extends VersionAwareResponseService<MyEntity3078AssocPickDTO, MyEntity3078Assoc> {
    private final MyEntity3078MultiRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3078AssocPickMeta> meta = MyEntity3078AssocPickMeta.class;

    @Override
    protected CreateResult<MyEntity3078AssocPickDTO> doCreateEntity(MyEntity3078Assoc entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3078AssocPickDTO> doUpdateEntity(MyEntity3078Assoc entity, MyEntity3078AssocPickDTO data,
                                                                       BusinessComponent bc) {
        setIfChanged(data, MyEntity3078AssocPickDTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyEntity3078AssocPickDTO_.customFieldText, entity::setCustomFieldText);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
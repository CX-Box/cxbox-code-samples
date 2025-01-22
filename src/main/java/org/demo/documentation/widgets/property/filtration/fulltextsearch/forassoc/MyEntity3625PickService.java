package org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3625PickService extends VersionAwareResponseService<MyEntity3625PickDTO, org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625> {

    private final MyEntity3625Repository repository;

    public MyEntity3625PickService(MyEntity3625Repository repository) {
        super(MyEntity3625PickDTO.class, org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625.class, null, MyEntity3625PickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3625PickDTO> doCreateEntity(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyEntity3625PickDTO> doUpdateEntity(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity, MyEntity3625PickDTO data,
                                                                  BusinessComponent bc) {
        setIfChanged(data, MyEntity3625PickDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
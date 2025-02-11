package org.demo.documentation.widgets.property.filtration.filtergroup.forassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3623PickService extends VersionAwareResponseService<MyEntity3623PickDTO, org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623> {

    private final MyEntity3623Repository repository;

    public MyEntity3623PickService(MyEntity3623Repository repository) {
        super(MyEntity3623PickDTO.class, org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623.class, null, MyEntity3623PickMeta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyEntity3623PickDTO> doCreateEntity(org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3623PickDTO> doUpdateEntity(org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623 entity, MyEntity3623PickDTO data,
                                                                  BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
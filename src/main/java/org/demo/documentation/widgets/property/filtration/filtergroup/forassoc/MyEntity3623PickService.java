package org.demo.documentation.widgets.property.filtration.filtergroup.forassoc;

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
public class MyEntity3623PickService extends VersionAwareResponseService<MyEntity3623PickDTO, org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623> {

    private final MyEntity3623Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3623PickMeta> meta = MyEntity3623PickMeta.class;

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
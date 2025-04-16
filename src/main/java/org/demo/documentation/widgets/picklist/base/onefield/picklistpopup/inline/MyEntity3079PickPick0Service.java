package org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.inline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079PickRepository;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3079PickPick0Service extends VersionAwareResponseService<MyEntity3079PickPick0DTO, MyEntity3079Pick> {
    private final MyEntity3079PickRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3079PickPick0Meta> meta = MyEntity3079PickPick0Meta.class;

    @Override
    protected CreateResult<MyEntity3079PickPick0DTO> doCreateEntity(MyEntity3079Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3079PickPick0DTO> doUpdateEntity(MyEntity3079Pick entity, MyEntity3079PickPick0DTO data,
                                                                       BusinessComponent bc) {
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
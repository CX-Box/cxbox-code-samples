package org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.inline;

import lombok.Getter;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079PickRepository;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3079PickPick0Service extends VersionAwareResponseService<MyEntity3079PickPick0DTO, MyEntity3079Pick> {
    private final MyEntity3079PickRepository repository;

    public MyEntity3079PickPick0Service(MyEntity3079PickRepository repository) {
        super(MyEntity3079PickPick0DTO.class, MyEntity3079Pick.class, null, MyEntity3079PickPick0Meta.class);
        this.repository = repository;
    }

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
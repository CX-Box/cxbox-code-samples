package org.demo.documentation.widgets.groupinghierarhy.counter;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3201Service extends VersionAwareResponseService<MyExample3201DTO, MyEntity3201> {

    private final MyEntity3201Repository repository;

    public MyExample3201Service(MyEntity3201Repository repository) {
        super(MyExample3201DTO.class, MyEntity3201.class, null, MyExample3201Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3201DTO> doCreateEntity(MyEntity3201 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3201DTO> doUpdateEntity(MyEntity3201 entity, MyExample3201DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample3201DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
      if (data.isFieldChanged(MyExample3201DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3201DTO> getActions() {
        return Actions.<MyExample3201DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


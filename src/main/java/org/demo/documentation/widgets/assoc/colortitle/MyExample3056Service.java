package org.demo.documentation.widgets.assoc.colortitle;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3056Service extends VersionAwareResponseService<MyExample3056DTO, MyEntity3056> {

    private final MyEntity3056Repository repository;
  @Autowired
  private EntityManager entityManager;

  public MyExample3056Service(MyEntity3056Repository repository) {
        super(MyExample3056DTO.class, MyEntity3056.class, null, MyExample3056Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3056DTO> doCreateEntity(MyEntity3056 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3056DTO> doUpdateEntity(MyEntity3056 entity, MyExample3056DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3056DTO_.customFieldMultiConst)) {
        entity.getCustomFieldMultiConstList().clear();
        entity.getCustomFieldMultiConstList().addAll(data.getCustomFieldMultiConst().getValues().stream()
                .map(MultivalueFieldSingleValue::getId)
                .filter(Objects::nonNull)
                .map(Long::parseLong)
                .map(e -> entityManager.getReference(MyEntity3056Multi.class, e))
                .collect(Collectors.toList()));
      }
      if (data.isFieldChanged(MyExample3056DTO_.customFieldMulti)) {
        entity.getCustomFieldMultiList().clear();
        entity.getCustomFieldMultiList().addAll(data.getCustomFieldMulti().getValues().stream()
                .map(MultivalueFieldSingleValue::getId)
                .filter(Objects::nonNull)
                .map(Long::parseLong)
                .map(e -> entityManager.getReference(MyEntity3056Multi.class, e))
                .collect(Collectors.toList()));
      }

      return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3056DTO> getActions() {
        return Actions.<MyExample3056DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}

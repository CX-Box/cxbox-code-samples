package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist.MyEntity3862Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3862Service extends VersionAwareResponseService<MyExample3862DTO, MyEntity3862> {

    private final MyEntity3862Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3862Meta> meta = MyExample3862Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3862DTO> doCreateEntity(MyEntity3862 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3862DTO> doUpdateEntity(MyEntity3862 entity, MyExample3862DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3862DTO_.customFieldMultivalueDisplayedKey)) {
            entity.getCustomFieldMultivalueDisplayedKeyList().clear();
            entity.getCustomFieldMultivalueDisplayedKeyList().addAll(data.getCustomFieldMultivalueDisplayedKey().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3862Assoc.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3862DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3862Pick.class, data.getCustomFieldPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3862DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3862DTO> getActions() {
        return Actions.<MyExample3862DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}


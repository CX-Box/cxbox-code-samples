package org.demo.documentation.widgets.property.filtration.fulltextsearch;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist.MyEntity3614Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import static org.cxbox.api.data.dao.SpecificationUtils.and;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3614Service extends VersionAwareResponseService<MyExample3614DTO, MyEntity3614> {

    private final MyEntity3614Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3614Meta> meta = MyExample3614Meta.class;
    @Autowired
    private EntityManager entityManager;

    // --8<-- [start:getSpecification]
    @Override
    protected Specification<MyEntity3614> getSpecification(BusinessComponent bc) {
        var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
        var specification = super.getSpecification(bc);
        return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
    }
    // --8<-- [end:getSpecification]

    @Override
    protected CreateResult<MyExample3614DTO> doCreateEntity(MyEntity3614 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3614DTO> doUpdateEntity(MyEntity3614 entity, MyExample3614DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3614DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3614Pick.class, data.getCustomFieldPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3614DTO_.customFieldMultivalueDisplayedKey)) {
            entity.getCustomFieldMultivalueDisplayedKeyList().clear();
            entity.getCustomFieldMultivalueDisplayedKeyList().addAll(data.getCustomFieldMultivalueDisplayedKey().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3625.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3614DTO_.address)) {
            entity.setAddress(data.getAddress());
        }
        if (data.isFieldChanged(MyExample3614DTO_.fullName)) {
            entity.setFullName(data.getFullName());
        }
        if (data.isFieldChanged(MyExample3614DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3614DTO> getActions() {
        return Actions.<MyExample3614DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
    // --8<-- [end:getActions]

}

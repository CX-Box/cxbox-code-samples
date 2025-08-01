package org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import static org.cxbox.api.data.dao.SpecificationUtils.and;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3615Service extends VersionAwareResponseService<MyExample3615DTO, MyEntity3615> {

    private final MyEntity3615Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3615Meta> meta = MyExample3615Meta.class;

    @Override
    protected CreateResult<MyExample3615DTO> doCreateEntity(MyEntity3615 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3615DTO> doUpdateEntity(MyEntity3615 entity, MyExample3615DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3615DTO_.address)) {
            entity.setAddress(data.getAddress());
        }
        if (data.isFieldChanged(MyExample3615DTO_.fullName)) {
            entity.setFullName(data.getFullName());
        }
        if (data.isFieldChanged(MyExample3615DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3615DTO> getActions() {
        return Actions.<MyExample3615DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:getSpecification]
    @Override
    protected Specification<MyEntity3615> getSpecification(BusinessComponent bc) {
        var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
        var specification = super.getSpecification(bc);
        return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
    }
    // --8<-- [end:getSpecification]
}


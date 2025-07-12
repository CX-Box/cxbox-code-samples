package org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import static org.cxbox.api.data.dao.SpecificationUtils.and;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3625PickService extends VersionAwareResponseService<MyEntity3625PickDTO, org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625> {

    private final MyEntity3625Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3625PickMeta> meta = MyEntity3625PickMeta.class;

    // --8<-- [start:getSpecification]
    @Override
    protected Specification<MyEntity3625> getSpecification(BusinessComponent bc) {
        var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
        var specification = super.getSpecification(bc);
        return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
    }
    // --8<-- [end:getSpecification]

    @Override
    protected CreateResult<MyEntity3625PickDTO> doCreateEntity(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3625PickDTO> doUpdateEntity(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity, MyEntity3625PickDTO data,
                                                                  BusinessComponent bc) {
        setIfChanged(data, MyEntity3625PickDTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyEntity3625PickDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyEntity3625PickDTO> getActions() {
        return Actions.<MyEntity3625PickDTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}
package org.demo.documentation.widgets.property.filtration.fulltextsearch;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.cxbox.api.data.dao.SpecificationUtils.and;

@Service
public class MyExample3614Service extends VersionAwareResponseService<MyExample3614DTO, MyEntity3614> {

    private final MyEntity3614Repository repository;

    public MyExample3614Service(MyEntity3614Repository repository) {
        super(MyExample3614DTO.class, MyEntity3614.class, null, MyExample3614Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3614DTO> doCreateEntity(MyEntity3614 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3614DTO> doUpdateEntity(MyEntity3614 entity, MyExample3614DTO data, BusinessComponent bc) {
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
    // --8<-- [start:getSpecification]
    @Override
    protected Specification<MyEntity3614> getSpecification(BusinessComponent bc) {
        var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
        var specification = super.getSpecification(bc);
        return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
    }
    // --8<-- [end:getSpecification]
}

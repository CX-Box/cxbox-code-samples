package org.demo.documentation.widgets.assoc.base.forfield;

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
public class MyEntity3053MultiMultivalueService extends VersionAwareResponseService<MyEntity3053MultiMultivalueDTO, org.demo.documentation.widgets.assoc.base.forfield.MyEntity3053Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3053MultiMultivalueMeta> meta = MyEntity3053MultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3053MultiMultivalueDTO> doCreateEntity(MyEntity3053Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3053MultiMultivalueDTO> doUpdateEntity(MyEntity3053Multi entity, MyEntity3053MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        setIfChanged(data, MyEntity3053MultiMultivalueDTO_.customFieldNew, entity::setCustomFieldNew);
        return null;
    }


}
package org.demo.documentation.other.forceactive2.allfields;

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
public class MyEntity4902SuggectionPickService extends VersionAwareResponseService<MyEntity4902SuggectionPickDTO, MyEntity4902Suggection> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4902SuggectionPickMeta> meta = MyEntity4902SuggectionPickMeta.class;

    @Override
    protected CreateResult<MyEntity4902SuggectionPickDTO> doCreateEntity(MyEntity4902Suggection entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902SuggectionPickDTO> doUpdateEntity(MyEntity4902Suggection entity, MyEntity4902SuggectionPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}
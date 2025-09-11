package org.demo.documentation.navigation.tab.typestandard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.fileupload.validationbusinessex.MyEntity103;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.navigation.tab.typestandard.MyEntity103PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity103PickService extends VersionAwareResponseService<MyEntity103PickDTO, MyEntity103> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity103PickMeta> meta = MyEntity103PickMeta.class;

    @Override
    protected CreateResult<MyEntity103PickDTO> doCreateEntity(MyEntity103 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity103PickDTO> doUpdateEntity(MyEntity103 entity, MyEntity103PickDTO data,
                                                                 BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
package org.demo.documentation.fields.multivaluehover.filtration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity234Service extends VersionAwareResponseService<MyEntity234DTO, MyEntity234> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity234Meta> meta = MyEntity234Meta.class;

    @Override
	protected CreateResult<MyEntity234DTO> doCreateEntity(MyEntity234 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity234DTO> doUpdateEntity(MyEntity234 entity, MyEntity234DTO data,
			BusinessComponent bc) {
		return null;
	}


}
package org.demo.documentation.fields.multivaluetree.validationdynamic;


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
public class MyEntity3327MultivalueService extends VersionAwareResponseService<MyEntity3327MultivalueDTO, MyEntity3327Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3327MultivalueMeta> meta = MyEntity3327MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3327MultivalueDTO> doCreateEntity(MyEntity3327Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3327MultivalueDTO> doUpdateEntity(MyEntity3327Multivalue entity, MyEntity3327MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}
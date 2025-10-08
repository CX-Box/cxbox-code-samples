package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

@Service
@RequiredArgsConstructor
public class MyExample3250MultivalueService extends VersionAwareResponseService<MyExample3250MultivalueDTO, MyExample3250Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3250MultivalueMeta> meta = MyExample3250MultivalueMeta.class;

	@Override
	protected CreateResult<MyExample3250MultivalueDTO> doCreateEntity(final MyExample3250Multivalue entity, final BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyExample3250MultivalueDTO> doUpdateEntity(final MyExample3250Multivalue entity, final MyExample3250MultivalueDTO data,
																																			 final BusinessComponent bc) {
		return null;
	}

}

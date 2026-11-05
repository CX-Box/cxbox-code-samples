package org.demo.documentation.fields.property.snapshotkey;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5900PickService extends VersionAwareResponseService<MyExample5900PickDTO, MyEntity5900Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5900PickMeta> meta = MyExample5900PickMeta.class;

	@Override
	protected CreateResult<MyExample5900PickDTO> doCreateEntity(MyEntity5900Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyExample5900PickDTO> doUpdateEntity(MyEntity5900Pick entity, MyExample5900PickDTO data,
			BusinessComponent bc) {
		return null;
	}

}

package org.demo.documentation.other.forceactive2.forproject;
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
public class MyEntity4903PickPickService extends VersionAwareResponseService<MyEntity4903PickPickDTO, MyEntity4903Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4903PickPickMeta> meta = MyEntity4903PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity4903PickPickDTO> doCreateEntity(MyEntity4903Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity4903PickPickDTO> doUpdateEntity(MyEntity4903Pick entity, MyEntity4903PickPickDTO data,
                                                                      BusinessComponent bc) {
		return null;
	}


}
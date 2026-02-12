package org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.picklist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079PickRepository;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3079PickPickService extends VersionAwareResponseService<MyEntity3079PickPickDTO, MyEntity3079Pick> {
	private final MyEntity3079PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3079PickPickMeta> meta = MyEntity3079PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3079PickPickDTO> doCreateEntity(MyEntity3079Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3079PickPickDTO> doUpdateEntity(MyEntity3079Pick entity, MyEntity3079PickPickDTO data,
																	  BusinessComponent bc) {
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
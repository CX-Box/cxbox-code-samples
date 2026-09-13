package org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.picktree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.MyEntity3351Pick;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.MyEntity3351PickRepository;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3351PickPickService extends VersionAwareResponseService<MyEntity3351PickPickDTO, MyEntity3351Pick> {
	private final MyEntity3351PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3351PickPickMeta> meta = MyEntity3351PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3351PickPickDTO> doCreateEntity(MyEntity3351Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3351PickPickDTO> doUpdateEntity(MyEntity3351Pick entity, MyEntity3351PickPickDTO data,
																	  BusinessComponent bc) {
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
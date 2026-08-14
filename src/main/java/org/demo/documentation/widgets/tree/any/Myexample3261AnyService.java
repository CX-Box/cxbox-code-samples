package org.demo.documentation.widgets.tree.any;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Getter
@Service
@RequiredArgsConstructor
public class Myexample3261AnyService extends AnySourceVersionAwareResponseService<Myexample3261AnyDTO, Myexample3261AnyDTO> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261AnyMetaBuilder> meta = Myexample3261AnyMetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261AnyDAO> dao = Myexample3261AnyDAO.class;

	@Override
	protected CreateResult<Myexample3261AnyDTO> doCreateEntity(Myexample3261AnyDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<Myexample3261AnyDTO> doUpdateEntity(Myexample3261AnyDTO entity, Myexample3261AnyDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3261AnyDTO> getActions() {
		return Actions.<Myexample3261AnyDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}
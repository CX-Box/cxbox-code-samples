package org.demo.documentation.widgets.funnel.base;

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
public class MyExampleBc5041Service extends AnySourceVersionAwareResponseService<MyExampleBc5041DTO, MyExampleBc5041DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5041MetaBuilder> meta = MyExampleBc5041MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5041DAO> dao = MyExampleBc5041DAO.class;

	@Override
	protected CreateResult<MyExampleBc5041DTO> doCreateEntity(MyExampleBc5041DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5041DTO> doUpdateEntity(MyExampleBc5041DTO entity, MyExampleBc5041DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5041DTO> getActions() {
		return Actions.<MyExampleBc5041DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}
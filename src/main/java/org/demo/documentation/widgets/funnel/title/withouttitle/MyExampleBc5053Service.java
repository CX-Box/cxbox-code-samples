package org.demo.documentation.widgets.funnel.title.withouttitle;

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
public class MyExampleBc5053Service extends AnySourceVersionAwareResponseService<MyExampleBc5053DTO, MyExampleBc5053DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5053MetaBuilder> meta = MyExampleBc5053MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5053DAO> dao = MyExampleBc5053DAO.class;

	@Override
	protected CreateResult<MyExampleBc5053DTO> doCreateEntity(MyExampleBc5053DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5053DTO> doUpdateEntity(MyExampleBc5053DTO entity, MyExampleBc5053DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5053DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5053DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5053DTO> getActions() {
		return Actions.<MyExampleBc5053DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}
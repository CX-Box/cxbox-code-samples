package org.demo.documentation.widgets.funnel.drilldown.parentchild;

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
public class MyExampleBc5048Service extends AnySourceVersionAwareResponseService<MyExampleBc5048DTO, MyExampleBc5048DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5048MetaBuilder> meta = MyExampleBc5048MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5048DAO> dao = MyExampleBc5048DAO.class;

	@Override
	protected CreateResult<MyExampleBc5048DTO> doCreateEntity(MyExampleBc5048DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5048DTO> doUpdateEntity(MyExampleBc5048DTO entity, MyExampleBc5048DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5048DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5048DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5048DTO> getActions() {
		return Actions.<MyExampleBc5048DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}
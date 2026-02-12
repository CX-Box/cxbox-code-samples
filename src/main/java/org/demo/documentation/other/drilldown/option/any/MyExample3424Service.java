package org.demo.documentation.other.drilldown.option.any;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3424Service extends AnySourceVersionAwareResponseService<MyExample3424DTO, MyEntity3424OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3424Meta> meta = MyExample3424Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3424Dao> dao = MyEntity3424Dao.class;


	@Override
	protected CreateResult<MyExample3424DTO> doCreateEntity(MyEntity3424OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3424DTO> doUpdateEntity(MyEntity3424OutServiceDTO entity, MyExample3424DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3424DTO> getActions() {
		return Actions.<MyExample3424DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}
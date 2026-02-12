package org.demo.documentation.other.drilldown.option3.any;

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
public class MyExample3435Service extends AnySourceVersionAwareResponseService<MyExample3435DTO, MyEntity3435OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3435Meta> meta = MyExample3435Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3435Dao> dao = MyEntity3435Dao.class;


	@Override
	protected CreateResult<MyExample3435DTO> doCreateEntity(MyEntity3435OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3435DTO> doUpdateEntity(MyEntity3435OutServiceDTO entity, MyExample3435DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3435DTO> getActions() {
		return Actions.<MyExample3435DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}
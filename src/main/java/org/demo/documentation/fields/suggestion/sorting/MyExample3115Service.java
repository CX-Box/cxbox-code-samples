package org.demo.documentation.fields.suggestion.sorting;

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
public class MyExample3115Service extends AnySourceVersionAwareResponseService<MyExample3115DTO, MyEntity3115OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3115Meta> meta = MyExample3115Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3115Dao> dao = MyEntity3115Dao.class;


	@Override
	protected CreateResult<MyExample3115DTO> doCreateEntity(MyEntity3115OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3115DTO> doUpdateEntity(MyEntity3115OutServiceDTO entity, MyExample3115DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3115DTO> getActions() {
		return Actions.<MyExample3115DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}
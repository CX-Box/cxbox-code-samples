package org.demo.documentation.fields.multivaluehover.validationconfirm;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample243Service extends VersionAwareResponseService<MyExample243DTO, MyEntity243> {

	private final MyEntity243Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample243Meta> meta = MyExample243Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample243DTO> doCreateEntity(MyEntity243 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample243DTO> doUpdateEntity(MyEntity243 entity, MyExample243DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample243DTO_.customFieldMultiHover)) {
			entity.getCustomFieldMultiHoverList().clear();
			entity.getCustomFieldMultiHoverList().addAll(data.getCustomFieldMultiHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity244.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample243DTO> getActions() {
		return Actions.<MyExample243DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
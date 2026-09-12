package org.demo.documentation.widgets.assoctree.actions.other.customsave;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3334Service extends VersionAwareResponseService<MyExample3334DTO, MyEntity3334> {

	private final MyEntity3334Repository repository;

	private final MyEntity3334MultiRepository repositoryMulti;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3334Meta> meta = MyExample3334Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3334DTO> doCreateEntity(MyEntity3334 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3334DTO> doUpdateEntity(MyEntity3334 entity, MyExample3334DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3334DTO_.customFieldRequired, entity::setCustomFieldRequired);
		if (data.isFieldChanged(MyExample3334DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3334Multi.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3334DTO> getActions() {
		return Actions.<MyExample3334DTO>builder()
				.create(crt -> crt.text("Add"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.action("custom save", "Custom Save")
						.invoker(this::customSave)
				)
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:customSave]
	private ActionResultDTO<MyExample3334DTO> customSave(BusinessComponent bc, MyExample3334DTO dto) {
		Optional<MyEntity3334> entity = repository.findById(bc.getIdAsLong());
		if (entity.isEmpty()) {
			return null;
		}
		List<MyEntity3334Multi> listMultivalue = new ArrayList<>();
		dto.getCustomField().getValues().forEach(v -> {
			Optional<MyEntity3334Multi> entityChild = repositoryMulti.findById(Long.valueOf(v.getId()));
			entityChild.ifPresent(listMultivalue::add);
		});
		entity.get().setCustomFieldList(listMultivalue);
		return new ActionResultDTO<>(entityToDto(bc, entity.get()));
	}
	// --8<-- [end:customSave]


}


package org.demo.documentation.widgets.assoctree.actions.other.buttonassoc;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
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
public class MyExample3333Service extends VersionAwareResponseService<MyExample3333DTO, MyEntity3333> {

	private final MyEntity3333Repository repository;

	private final MyEntity3333MultiRepository repositoryMulti;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3333Meta> meta = MyExample3333Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3333DTO> doCreateEntity(MyEntity3333 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3333DTO> doUpdateEntity(MyEntity3333 entity, MyExample3333DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3333DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3333DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3333Multi.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		Optional<MyEntity3333> entity = repository.findById(bc.getIdAsLong());
		if (entity.isEmpty()) {
			return null;
		}
		List<MyEntity3333Multi> listMultivalue = new ArrayList<>();
		for (AssociateDTO item : data) {
			Optional<MyEntity3333Multi> entityChild = repositoryMulti.findById(Long.valueOf(item.getId()));
			entityChild.ifPresent(listMultivalue::add);
		}
		entity.get().setCustomFieldList(listMultivalue);
		List<DataResponseDTO> collect = entity.stream().<DataResponseDTO>map(e -> entityToDto(bc, e))
				.toList();
		return new AssociateResultDTO(collect);
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3333DTO> getActions() {
		return Actions.<MyExample3333DTO>builder()
				.associate(ast -> ast
						.text("Popup Assoc")
				)
				.build();
	}
	// --8<-- [end:getActions]
}

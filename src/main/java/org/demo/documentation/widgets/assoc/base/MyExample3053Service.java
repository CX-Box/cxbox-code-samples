package org.demo.documentation.widgets.assoc.base;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.assoc.base.forfield.MyEntity3053Multi;
import org.demo.documentation.widgets.assoc.base.forfield.MyEntity3053MultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3053Service extends VersionAwareResponseService<MyExample3053DTO, MyEntity3053> {

	private final MyEntity3053Repository repository;

	private final MyEntity3053MultiRepository repositoryMulti;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3053Meta> meta = MyExample3053Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3053DTO> doCreateEntity(MyEntity3053 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3053DTO> doUpdateEntity(MyEntity3053 entity, MyExample3053DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3053DTO_.customFieldNew, entity::setCustomFieldNew);
		if (data.isFieldChanged(MyExample3053DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3053Multi.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doAssociate]
	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		List<MyEntity3053> myEntity3053List = addNewRecords(data, bc);
		List<MyExample3053DTO> collect = myEntity3053List.stream()
				.map(e -> entityToDto(bc, e))
				.toList();
		return new AssociateResultDTO((List) collect);
	}
	// --8<-- [end:doAssociate]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3053DTO> getActions() {
		return Actions.<MyExample3053DTO>builder()
				.associate(ast -> ast
						.text("Popup Assoc")
				)
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:addNewRecords]
	@SneakyThrows
	private List<MyEntity3053> addNewRecords(List<AssociateDTO> dataIds, BusinessComponent bc) {
		List<MyEntity3053> recordList = new ArrayList<>();
		for (AssociateDTO item : dataIds) {
			List<MyEntity3053Multi> listMultivalue = new ArrayList<>();
			Optional<MyEntity3053Multi> entityChild = repositoryMulti.findById(Long.valueOf(item.getId()));
			listMultivalue.add(entityChild.get());
			MyEntity3053 myEntity3053 = new MyEntity3053().setCustomFieldList(listMultivalue).setCustomFieldNew(entityChild.get().getCustomFieldNew());
			recordList.add(repository.save(myEntity3053));
		}
		return recordList;
	}
	// --8<-- [end:addNewRecords]
}

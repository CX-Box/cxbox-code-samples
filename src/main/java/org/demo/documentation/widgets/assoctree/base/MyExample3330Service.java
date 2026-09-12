package org.demo.documentation.widgets.assoctree.base;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330Multi;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330MultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3330Service extends VersionAwareResponseService<MyExample3330DTO, MyEntity3330> {

	private final MyEntity3330Repository repository;

	private final MyEntity3330MultiRepository repositoryMulti;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3330Meta> meta = MyExample3330Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3330DTO> doCreateEntity(MyEntity3330 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3330DTO> doUpdateEntity(MyEntity3330 entity, MyExample3330DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3330DTO_.customFieldNew, entity::setCustomFieldNew);
		if (data.isFieldChanged(MyExample3330DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3330Multi.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doAssociate]
	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		List<MyEntity3330> myEntity3330List = addNewRecords(data, bc);
		List<DataResponseDTO> collect = myEntity3330List.stream()
				.<DataResponseDTO>map(e -> entityToDto(bc, e))
				.toList();
		return new AssociateResultDTO(collect);
	}
	// --8<-- [end:doAssociate]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3330DTO> getActions() {
		return Actions.<MyExample3330DTO>builder()
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
	private List<MyEntity3330> addNewRecords(List<AssociateDTO> dataIds, BusinessComponent bc) {
		List<MyEntity3330> recordList = new ArrayList<>();
		for (AssociateDTO item : dataIds) {
			List<MyEntity3330Multi> listMultivalue = new ArrayList<>();
			MyEntity3330Multi entityChild = repositoryMulti.findById(Long.valueOf(item.getId())).orElseThrow();
			listMultivalue.add(entityChild);
			MyEntity3330 myEntity3330 = new MyEntity3330().setCustomFieldList(listMultivalue).setCustomFieldNew(entityChild.getCustomFieldNew());
			recordList.add(repository.save(myEntity3330));
		}
		return recordList;
	}
	// --8<-- [end:addNewRecords]
}

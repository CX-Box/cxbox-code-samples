package org.demo.documentation.multivaluehover.drilldown;

import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample231Service extends VersionAwareResponseService<MyExample231DTO, MyEntity231> {

	private final MyEntity231Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample231Service(MyEntity231Repository repository) {
		super(MyExample231DTO.class, MyEntity231.class, null, MyExample231Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample231DTO> doCreateEntity(MyEntity231 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample231DTO> doUpdateEntity(MyEntity231 entity, MyExample231DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample231DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity232.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample231DTO> getActions() {
		return Actions.<MyExample231DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}
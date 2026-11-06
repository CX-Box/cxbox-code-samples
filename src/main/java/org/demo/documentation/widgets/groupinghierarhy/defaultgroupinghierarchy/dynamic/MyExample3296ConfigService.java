package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3296ConfigService extends VersionAwareResponseService<MyExample3296ConfigDTO, MyEntity3296Config> {

	private final MyEntity3296ConfigRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3296ConfigMeta> meta = MyExample3296ConfigMeta.class;

	@Override
	protected CreateResult<MyExample3296ConfigDTO> doCreateEntity(MyEntity3296Config entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3296ConfigDTO> doUpdateEntity(MyEntity3296Config entity,
			MyExample3296ConfigDTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3296ConfigDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample3296ConfigDTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
		setIfChanged(data, MyExample3296ConfigDTO_.defaultExpanded, entity::setDefaultExpanded);
		// default hierarchy of the GroupingHierarchy widget is built from this table, so the widget is refreshed
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(CxboxMyExample3296Controller.myexample3296));
	}

	@Override
	public Actions<MyExample3296ConfigDTO> getActions() {
		return Actions.<MyExample3296ConfigDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}

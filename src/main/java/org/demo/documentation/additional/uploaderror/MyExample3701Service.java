package org.demo.documentation.additional.uploaderror;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.cxbox.core.file.service.CxboxFileService;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3701Service extends VersionAwareResponseService<MyExample3701DTO, MyEntity3701> {
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3701Meta> meta = MyExample3701Meta.class;
	private final MyEntity3701Repository repository;
	@Autowired
	private CxboxFileService cxboxFileService;

	@Override
	protected CreateResult<MyExample3701DTO> doCreateEntity(MyEntity3701 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3701DTO> doUpdateEntity(MyEntity3701 entity, MyExample3701DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3701DTO_.customFieldFileId, entity::setCustomFieldFileId);
		setIfChanged(data, MyExample3701DTO_.customFieldFile, entity::setCustomFieldFile);
		if (data.isFieldChanged(MyExample3701DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		List<MyEntity3701> documents = fileUpload(data);
		List<MyExample3701DTO> collect = documents.stream().map(e -> entityToDto(bc, e))
				.collect(Collectors.toList());
		return new AssociateResultDTO((List) collect);
	}

	@SneakyThrows
	private List<MyEntity3701> fileUpload(List<AssociateDTO> fileIds) {
		List<MyEntity3701> meetingDocumentsList = new ArrayList<>();
		for (AssociateDTO item : fileIds) {
			var documents = new MyEntity3701();
			var fileId = item.getId();
			documents.setCustomFieldFileId(fileId);
			FileDownloadDto download = cxboxFileService.download(fileId, null);
			documents.setCustomFieldFile(download.getName());
			meetingDocumentsList.add(repository.save(documents));

		}
		return meetingDocumentsList;
	}

	@Override
	public Actions<MyExample3701DTO> getActions() {
		return Actions.<MyExample3701DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.associate(ast -> ast
						.withCustomParameter(Map.of("subtype", "multiFileUpload"))
						.text("Add Files")
				)
				.build();
	}


}


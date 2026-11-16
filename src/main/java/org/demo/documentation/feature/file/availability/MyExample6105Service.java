package org.demo.documentation.feature.file.availability;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.cxbox.core.file.service.CxboxFileService;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.feature.file.availability.enums.StatusEnum;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6105Service extends VersionAwareResponseService<MyExample6105DTO, MyEntity6105> {

	private final CxboxFileService cxboxFileService;

	private final MyEntity6105Repository repository;

	private final MyEntity6104Repository repositoryParent;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6105Meta> meta = MyExample6105Meta.class;

	@Override
	protected Specification<MyEntity6105> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity6105_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample6105DTO> doCreateEntity(MyEntity6105 entity, BusinessComponent bc) {
		entity.setCustomFieldEntity(repositoryParent.getReferenceById(bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6105DTO> doUpdateEntity(MyEntity6105 entity, MyExample6105DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample6105DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample6105DTO_.customFieldFileId, entity::setCustomFieldFileId);
		setIfChanged(data, MyExample6105DTO_.customFieldFile, entity::setCustomFieldFile);
		setIfChanged(data, MyExample6105DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample6105DTO> getActions() {
		return Actions.<MyExample6105DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt.text("Create"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.associate(ast -> ast
						.withCustomParameter(Map.of("subtype", "multiFileUpload"))
						.text("Add Files")
						.available(this::isTaskOpen)
				)
				.build();
	}

	private boolean isTaskOpen(BusinessComponent bc) {
		return repositoryParent.findById(bc.getParentIdAsLong())
				.map(task -> task.getStatus() != StatusEnum.CLOSED)
				.orElse(false);
	}
	// --8<-- [end:getActions]

	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		List<MyEntity6105> documents = fileUpload(bc, data);
		List<DataResponseDTO> collect = documents.stream()
				.<DataResponseDTO>map(e -> entityToDto(bc, e))
				.toList();
		return new AssociateResultDTO(collect);
	}

	private List<MyEntity6105> fileUpload(BusinessComponent bc, List<AssociateDTO> fileIds) {
		MyEntity6104 task = repositoryParent.getReferenceById(bc.getParentIdAsLong());
		List<MyEntity6105> documents = new ArrayList<>();
		for (AssociateDTO item : fileIds) {
			var document = new MyEntity6105();
			var fileId = item.getId();
			FileDownloadDto download = cxboxFileService.download(fileId, null);
			document.setCustomFieldEntity(task);
			document.setCustomFieldFileId(fileId);
			document.setCustomFieldFile(download.getName());
			documents.add(repository.save(document));
		}
		return documents;
	}

}

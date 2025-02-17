package org.demo.documentation.other.savewithparent.example5.service;

import static org.demo.services.CustomFileUploadServices.FILENAME_FIELD;

import io.minio.MinioClient;
import io.minio.StatObjectArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDocumentDTO;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDocumentDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.TaskDocument;
import org.demo.documentation.other.savewithparent.example5.entity.TaskDocument_;
import org.demo.documentation.other.savewithparent.example5.entity.Task;
import org.demo.documentation.other.savewithparent.example5.repositories.TaskDocumentRepository;
import org.demo.documentation.other.savewithparent.example5.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample5555TaskDocumentService extends VersionAwareResponseService<TaskDocumentDTO, TaskDocument> {

	private final TaskRepository taskRepository;

	private final TaskDocumentRepository documentRepository;

	@Autowired
	private MinioClient minioClient;

	@Value("${minio.bucket.name}")
	private String defaultBucketName;

	public MyExample5555TaskDocumentService(TaskRepository taskRepository,
			TaskDocumentRepository documentRepository) {
		super(TaskDocumentDTO.class, TaskDocument.class, null, MyExample5555TaskDocumentMeta.class);
		this.taskRepository = taskRepository;
		this.documentRepository = documentRepository;
	}

	@Override
	protected CreateResult<TaskDocumentDTO> doCreateEntity(TaskDocument entity, BusinessComponent bc) {
		Task task = taskRepository.getReferenceById(bc.getParentIdAsLong());
		entity.setTask(task);
		documentRepository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<TaskDocumentDTO> doUpdateEntity(TaskDocument entity, TaskDocumentDTO data,
			BusinessComponent bc) {
		setIfChanged(data, TaskDocumentDTO_.id, entity::setFileId);
		setIfChanged(data, TaskDocumentDTO_.file, entity::setFile);
		if (data.isFieldChanged(TaskDocumentDTO_.taskId)) {
			Optional.ofNullable(data.getTaskId())
					.ifPresent(taskId -> {
						Task task = taskRepository.getReferenceById(taskId);
						entity.setTask(task);
					});
		}
		documentRepository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

    @Override
    public Actions<TaskDocumentDTO> getActions() {
        return Actions.<TaskDocumentDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .associate(ast -> ast
                        .withCustomParameter(Map.of("subtype", "multiFileUpload"))
                        .text("Add Files")
                ).build();
    }

	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		List<TaskDocument> documents = fileUpload(data, bc);
		List<TaskDocumentDTO> collect = documents.stream()
				.map(e -> entityToDto(bc, e))
				.map(documentDTO -> documentDTO.setTaskId(bc.getParentIdAsLong()))
				.toList();
		return new AssociateResultDTO((List) collect);
	}

	@SneakyThrows
	private List<TaskDocument> fileUpload(List<AssociateDTO> fileIds, BusinessComponent bc) {
		List<TaskDocument> fileList = new ArrayList<>();
		for (AssociateDTO item : fileIds) {
			var documents = new TaskDocument();
			var fileId = item.getId();
			documents.setFileId(fileId);
			var statObjectResponse = minioClient.statObject(StatObjectArgs
					.builder()
					.bucket(defaultBucketName)
					.object(fileId)
					.build()
			);
			var fileName = statObjectResponse.userMetadata().get(FILENAME_FIELD);
			documents.setFile(fileName);
			Optional.of(taskRepository.getReferenceById(bc.getParentIdAsLong()))
					.ifPresent(documents::setTask);
			fileList.add(documentRepository.save(documents));
		}
		return fileList;
	}


	@Override
	protected Specification<TaskDocument> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(TaskDocument_.task).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

}

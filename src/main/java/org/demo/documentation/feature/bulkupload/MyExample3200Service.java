package org.demo.documentation.feature.bulkupload;

import io.minio.MinioClient;
import io.minio.StatObjectArgs;
import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.demo.conf.cxbox.customization.file.FileService.FILENAME_FIELD;


@Service
public class MyExample3200Service extends VersionAwareResponseService<MyExample3200DTO, MyEntity3200> {
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String defaultBucketName;

    private final MyEntity3200Repository repository;

    public MyExample3200Service(MyEntity3200Repository repository) {
        super(MyExample3200DTO.class, MyEntity3200.class, null, MyExample3200Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3200DTO> doCreateEntity(MyEntity3200 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3200DTO> doUpdateEntity(MyEntity3200 entity, MyExample3200DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3200DTO_.customFieldFileId, entity::setCustomFieldFileId);
        setIfChanged(data, MyExample3200DTO_.customFieldFile, entity::setCustomFieldFile);
        if (data.isFieldChanged(MyExample3200DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
        List<MyEntity3200> documents = fileUpload(data);
        List<MyExample3200DTO> collect = documents.stream().map(e -> entityToDto(bc, e))
                .collect(Collectors.toList());
        return new AssociateResultDTO((List) collect);
    }

    @SneakyThrows
    private List<MyEntity3200> fileUpload(List<AssociateDTO> fileIds) {
        List<MyEntity3200> meetingDocumentsList = new ArrayList<>();
        for (AssociateDTO item : fileIds) {
            var documents = new MyEntity3200();
            var fileId = item.getId();
            documents.setCustomFieldFileId(fileId);
            var statObjectResponse = minioClient.statObject(StatObjectArgs
                    .builder()
                    .bucket(defaultBucketName)
                    .object(fileId)
                    .build()
            );
            var fileName = statObjectResponse.userMetadata().get(FILENAME_FIELD);
            documents.setCustomFieldFile(fileName);
            meetingDocumentsList.add(repository.save(documents));

        }
        return meetingDocumentsList;
    }

    @Override
    public Actions<MyExample3200DTO> getActions() {
        return Actions.<MyExample3200DTO>builder()
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


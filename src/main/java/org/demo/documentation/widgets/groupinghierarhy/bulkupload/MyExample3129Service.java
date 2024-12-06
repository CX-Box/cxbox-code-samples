package org.demo.documentation.widgets.groupinghierarhy.bulkupload;

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
public class MyExample3129Service extends VersionAwareResponseService<MyExample3129DTO, MyEntity3129> {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String defaultBucketName;

    private final MyEntity3129Repository repository;

    public MyExample3129Service(MyEntity3129Repository repository) {
        super(MyExample3129DTO.class, MyEntity3129.class, null, MyExample3129Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3129DTO> doCreateEntity(MyEntity3129 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3129DTO> doUpdateEntity(MyEntity3129 entity, MyExample3129DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3129DTO_.customFieldFileId, entity::setCustomFieldFileId);
        setIfChanged(data, MyExample3129DTO_.customFieldFile, entity::setCustomFieldFile);
        setIfChanged(data, MyExample3129DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3129DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
        List<MyEntity3129> documents = fileUpload(data);
        List<MyExample3129DTO> collect = documents.stream().map(e -> entityToDto(bc, e))
                .collect(Collectors.toList());
        return new AssociateResultDTO((List) collect);
    }

    @SneakyThrows
    private List<MyEntity3129> fileUpload(List<AssociateDTO> fileIds) {
        List<MyEntity3129> meetingDocumentsList = new ArrayList<>();
        for (AssociateDTO item : fileIds) {
            var documents = new MyEntity3129();
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
    public Actions<MyExample3129DTO> getActions() {
        return Actions.<MyExample3129DTO>builder()
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


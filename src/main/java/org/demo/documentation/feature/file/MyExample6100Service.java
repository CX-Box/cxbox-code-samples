package org.demo.documentation.feature.file;

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6100Service extends VersionAwareResponseService<MyExample6100DTO, MyEntity6100> {
    private final CxboxFileService cxboxFileService;
    private final MyEntity6100Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample6100Meta> meta = MyExample6100Meta.class;

    @Override
    protected CreateResult<MyExample6100DTO> doCreateEntity(MyEntity6100 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample6100DTO> doUpdateEntity(MyEntity6100 entity, MyExample6100DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample6100DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
      setIfChanged(data, MyExample6100DTO_.customFieldFileId, entity::setCustomFieldFileId);
      setIfChanged(data, MyExample6100DTO_.customFieldFile, entity::setCustomFieldFile);
      setIfChanged(data, MyExample6100DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

  // --8<-- [start:getActions]
    @Override
    public Actions<MyExample6100DTO> getActions() {
        return Actions.<MyExample6100DTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .associate(ast -> ast
                        .withCustomParameter(Map.of("subtype", "multiFileUpload"))
                        .text("Add Files")
                )
                .build();
    }
  // --8<-- [end:getActions]

  // --8<-- [start:doAssociate]
  @Override
  protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
    List<MyEntity6100> meetingDocuments = fileUpload(bc, data);
    List<MyExample6100DTO> collect = meetingDocuments.stream().map(e -> entityToDto(bc, e))
            .collect(Collectors.toList());

    return new AssociateResultDTO((List) collect);
  }
  // --8<-- [end:doAssociate]

  // --8<-- [start:fileUpload]
  @SneakyThrows
  private List<MyEntity6100> fileUpload(BusinessComponent bc, List<AssociateDTO> fileIds) {
    List<MyEntity6100> myEntity6100List = new ArrayList<>();
    for (AssociateDTO item : fileIds) {
      var myEntity6100 = new MyEntity6100();
      var fileId = item.getId();
      FileDownloadDto download = cxboxFileService.download(fileId, null);
      myEntity6100.setCustomFieldFileId(fileId);
      myEntity6100.setCustomFieldFile(download.getName());
      myEntity6100List.add(repository.save(myEntity6100));
    }
    return myEntity6100List;
  }
  // --8<-- [end:fileUpload]
}
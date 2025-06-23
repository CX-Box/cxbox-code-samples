package org.demo.documentation.other.forceactive2.forproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.forceactive2.forproject.enums.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4903DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "nameFSPPEntity.customField", provider = StringValueProvider.class)
    private String nameFSPP;
    @SearchParameter(name = "nameFSPPEntity.id", provider = LongValueProvider.class)
    private Long nameFSPPId;
    @SearchParameter(name = "placePresentation", provider = EnumValueProvider.class)
    private PlacePresentationEnum placePresentation;
    @SearchParameter(name = "nameOSPEntity.customField", provider = StringValueProvider.class)
    private String nameOSP;
    @SearchParameter(name = "nameOSPEntity.id", provider = LongValueProvider.class)
    private Long nameOSPId;
    @SearchParameter(name = "objectType", provider = EnumValueProvider.class)
    private ObjectTypeEnum objectType;
    @SearchParameter(name = "fileType", provider = EnumValueProvider.class)
    private FileTypeEnum fileType;
    @SearchParameter(name = "instanceEntity.customField", provider = StringValueProvider.class)
    private String instance;
    @SearchParameter(name = "instanceEntity.id", provider = LongValueProvider.class)
    private Long instanceId;
    @SearchParameter(name = "file", provider = StringValueProvider.class)
    private String file;
    private String fileId;
    @SearchParameter(name = "channel", provider = EnumValueProvider.class)
    private ChannelEnum channel;
    @SearchParameter(name = "usersName", provider = EnumValueProvider.class)
    private UsersNameEnum usersName;
    @SearchParameter(name = "nameFileEntity.customField", provider = StringValueProvider.class)
    private String nameFile;
    @SearchParameter(name = "nameFileEntity.id", provider = LongValueProvider.class)
    private Long nameFileId;

    public MyExample4903DTO(MyEntity4903 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.nameFSPPId = Optional.ofNullable(entity.getNameFSPPEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.nameFSPP = Optional.ofNullable(entity.getNameFSPPEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.placePresentation = entity.getPlacePresentation();
        this.nameOSPId = Optional.ofNullable(entity.getNameOSPEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.nameOSP = Optional.ofNullable(entity.getNameOSPEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.objectType = entity.getObjectType();
        this.fileType = entity.getFileType();
        this.instanceId = Optional.ofNullable(entity.getInstanceEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.instance = Optional.ofNullable(entity.getInstanceEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.file = entity.getFile();
        this.fileId = entity.getFileId();
        this.channel = entity.getChannel();
        this.usersName = entity.getUsersName();
        this.nameFileId = Optional.ofNullable(entity.getNameFileEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.nameFile = Optional.ofNullable(entity.getNameFileEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}

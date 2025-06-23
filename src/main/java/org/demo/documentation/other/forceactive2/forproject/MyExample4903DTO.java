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
import org.demo.documentation.other.forceactive2.forproject.enums.PlacePresentationEnum;

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
    }
}

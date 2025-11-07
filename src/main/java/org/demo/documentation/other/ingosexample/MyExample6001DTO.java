package org.demo.documentation.other.ingosexample;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.ingosexample.enums.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6001DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(name = "businessUnitName", provider = StringValueProvider.class)
    private String businessUnitName;

    @SearchParameter(name = "requestCategory", provider = EnumValueProvider.class)
    private RequestCategoryEnum requestCategory;

    @SearchParameter(name = "requestType", provider = EnumValueProvider.class)
    private RequestTypeEnum requestType;

    @SearchParameter(name = "territorialAffiliation", provider = EnumValueProvider.class)
    private TerritorialAffiliationEnum territorialAffiliation;

    @SearchParameter(name = "assignedUsers", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = AssignedUsersEnum.class)
    private MultivalueField assignedUsers;

    @SearchParameter(name = "assignedUsersDisplayKey", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = AssignedUsersDisplayKeyEnum.class)
    private MultivalueField assignedUsersDisplayKey;

    @SearchParameter(name = "businessUnitName2Entity.name", provider = StringValueProvider.class)
    private String businessUnitName2;

    @SearchParameter(name = "businessUnitName2Entity.id", provider = LongValueProvider.class)
    private Long businessUnitName2Id;

    @SearchParameter(name = "assignedUsers2", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = AssignedUsers2Enum.class)
    private MultivalueField assignedUsers2;

    @SearchParameter(name = "assignedUsers22", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = AssignedUsers22Enum.class)
    private MultivalueField assignedUsers22;

    public MyExample6001DTO(MyEntity6001 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.businessUnitName = entity.getBusinessUnitName();
        this.requestCategory = entity.getRequestCategory();
        this.requestType = entity.getRequestType();
        this.territorialAffiliation = entity.getTerritorialAffiliation();
        this.assignedUsers = entity.getAssignedUsers().stream().collect(MultivalueField.toMultivalueField(Enum::name, AssignedUsersEnum::getValue));
        this.assignedUsersDisplayKey = entity.getAssignedUsersDisplayKey().stream().collect(MultivalueField.toMultivalueField(Enum::name, AssignedUsersDisplayKeyEnum::getValue));
        this.businessUnitName2Id = Optional.ofNullable(entity.getBusinessUnitName2Entity())
                .map(e -> e.getId())
                .orElse(null);
        this.businessUnitName2 = Optional.ofNullable(entity.getBusinessUnitName2Entity())
                .map(e -> e.getName())
                .orElse(null);
        this.assignedUsers2 = entity.getAssignedUsers2().stream().collect(MultivalueField.toMultivalueField(Enum::name, AssignedUsers2Enum::getValue));
        this.assignedUsers22 = entity.getAssignedUsers22().stream().collect(MultivalueField.toMultivalueField(Enum::name, AssignedUsers22Enum::getValue));
    }
}

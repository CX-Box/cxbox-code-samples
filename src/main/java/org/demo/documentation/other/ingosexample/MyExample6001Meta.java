package org.demo.documentation.other.ingosexample;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.ingosexample.enums.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample6001Meta extends FieldMetaBuilder<MyExample6001DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6001DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setConcreteValues(MyExample6001DTO_.displayedKey, Arrays.stream(DisplayedKeyEnum.values())
                .map(DisplayedKeyEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample6001DTO_.displayedKey);
        fields.setConcreteValues(MyExample6001DTO_.etwtrrt, Arrays.stream(EtwtrrtEnum.values())
                .map(EtwtrrtEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample6001DTO_.etwtrrt);
        fields.setConcreteValues(MyExample6001DTO_.assignedUsers22, Arrays.stream(AssignedUsers22Enum.values())
                .map(AssignedUsers22Enum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample6001DTO_.assignedUsers22);
        fields.setConcreteValues(MyExample6001DTO_.assignedUsers2, Arrays.stream(AssignedUsers2Enum.values())
                .map(AssignedUsers2Enum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample6001DTO_.assignedUsers2);
        fields.setEnabled(MyExample6001DTO_.businessUnitName2Id);
        fields.setEnabled(MyExample6001DTO_.businessUnitName2);
        fields.setConcreteValues(MyExample6001DTO_.assignedUsersDisplayKey, Arrays.stream(AssignedUsersDisplayKeyEnum.values())
                .map(AssignedUsersDisplayKeyEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample6001DTO_.assignedUsersDisplayKey);
        fields.setConcreteValues(MyExample6001DTO_.assignedUsers, Arrays.stream(AssignedUsersEnum.values())
                .map(AssignedUsersEnum::getValue)
                .map(e -> new SimpleDictionary(e, e))
                .toList());
        fields.setEnabled(MyExample6001DTO_.assignedUsers);
        fields.setEnumValues(MyExample6001DTO_.territorialAffiliation, TerritorialAffiliationEnum.values());
        fields.setEnabled(MyExample6001DTO_.territorialAffiliation);
        fields.setEnumValues(MyExample6001DTO_.requestType, RequestTypeEnum.values());
        fields.setEnabled(MyExample6001DTO_.requestType);
        fields.setEnumValues(MyExample6001DTO_.requestCategory, RequestCategoryEnum.values());
        fields.setEnabled(MyExample6001DTO_.requestCategory);
        fields.setEnabled(MyExample6001DTO_.businessUnitName);
        fields.setEnabled(MyExample6001DTO_.customField);
        fields.setEnabled(MyExample6001DTO_.customField2);

        fields.setEnabled(
                MyExample6001DTO_.businessUnitName2Id,
                MyExample6001DTO_.businessUnitName2,
                MyExample6001DTO_.requestCategory,
                MyExample6001DTO_.requestType,
                MyExample6001DTO_.territorialAffiliation
        );
        fields.setRequired(
                MyExample6001DTO_.businessUnitName2Id,
                MyExample6001DTO_.businessUnitName2,
                MyExample6001DTO_.requestCategory,
                MyExample6001DTO_.requestType,
                MyExample6001DTO_.territorialAffiliation
        );


        fields.setEnabled(MyExample6001DTO_.assignedUsers);
        fields.setRequired(MyExample6001DTO_.assignedUsers);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample6001DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.setConcreteFilterValues(MyExample6001DTO_.displayedKey, Arrays.stream(DisplayedKeyEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample6001DTO_.displayedKey);
        fields.setConcreteFilterValues(MyExample6001DTO_.etwtrrt, Arrays.stream(EtwtrrtEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample6001DTO_.etwtrrt);
        fields.setConcreteFilterValues(MyExample6001DTO_.assignedUsers22, Arrays.stream(AssignedUsers22Enum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample6001DTO_.assignedUsers22);
        fields.setConcreteFilterValues(MyExample6001DTO_.assignedUsers2, Arrays.stream(AssignedUsers2Enum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample6001DTO_.assignedUsers2);
        fields.enableFilter(MyExample6001DTO_.businessUnitName2);
        fields.setConcreteFilterValues(MyExample6001DTO_.assignedUsersDisplayKey, Arrays.stream(AssignedUsersDisplayKeyEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample6001DTO_.assignedUsersDisplayKey);
        fields.setConcreteFilterValues(MyExample6001DTO_.assignedUsers, Arrays.stream(AssignedUsersEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample6001DTO_.assignedUsers);
        fields.setEnumFilterValues(fields, MyExample6001DTO_.territorialAffiliation, TerritorialAffiliationEnum.values());
        fields.enableFilter(MyExample6001DTO_.territorialAffiliation);
        fields.setEnumFilterValues(fields, MyExample6001DTO_.requestType, RequestTypeEnum.values());
        fields.enableFilter(MyExample6001DTO_.requestType);
        fields.setEnumFilterValues(fields, MyExample6001DTO_.requestCategory, RequestCategoryEnum.values());
        fields.enableFilter(MyExample6001DTO_.requestCategory);
        fields.enableFilter(MyExample6001DTO_.businessUnitName);
        fields.setForceActive(
                MyExample6001DTO_.requestCategory,
                MyExample6001DTO_.businessUnitName2
        );
    }

}
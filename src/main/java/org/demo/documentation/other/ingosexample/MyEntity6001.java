package org.demo.documentation.other.ingosexample;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.ingosexample.enums.*;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity6001 extends BaseEntity {
    @Column
    private String customField;

    @Column
    private String businessUnitName;

    @Enumerated(value = EnumType.STRING)
    @Column
    private RequestCategoryEnum requestCategory;

    @Enumerated(value = EnumType.STRING)
    @Column
    private RequestTypeEnum requestType;

    @Enumerated(value = EnumType.STRING)
    @Column
    private TerritorialAffiliationEnum territorialAffiliation;

    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "ASSIGNED_USERS_MYEXAMPLE6001", joinColumns = @JoinColumn(name = "MyEntity6001_ID"))
    @ElementCollection(targetClass = AssignedUsersEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<AssignedUsersEnum> assignedUsers = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "ASSIGNED_USERS_DISPLAY_KEY_MYEXAMPLE6001", joinColumns = @JoinColumn(name = "MyEntity6001_ID"))
    @ElementCollection(targetClass = AssignedUsersDisplayKeyEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<AssignedUsersDisplayKeyEnum> assignedUsersDisplayKey = new HashSet<>();

    @JoinColumn(name = "BUSINESS_UNIT_NAME2_ID")
    @ManyToOne
    private ApplicationEntity businessUnitName2Entity;

    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "ASSIGNED_USERS2_MYEXAMPLE6001", joinColumns = @JoinColumn(name = "MyEntity6001_ID"))
    @ElementCollection(targetClass = AssignedUsers2Enum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<AssignedUsers2Enum> assignedUsers2 = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "ASSIGNED_USERS22_MYEXAMPLE6001", joinColumns = @JoinColumn(name = "MyEntity6001_ID"))
    @ElementCollection(targetClass = AssignedUsers22Enum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<AssignedUsers22Enum> assignedUsers22 = new HashSet<>();
}

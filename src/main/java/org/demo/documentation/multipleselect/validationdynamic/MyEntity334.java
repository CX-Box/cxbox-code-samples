package org.demo.documentation.multipleselect.validationdynamic;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.multipleselect.validationconfirm.enums.CustomFieldEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity334 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_334", joinColumns = @JoinColumn(name = "MyEntity334_ID"))
	@ElementCollection(targetClass = CustomFieldEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomFieldEnum> customField = new HashSet<>();

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_ADDITIONAL_334", joinColumns = @JoinColumn(name = "MyEntity334_ID"))
	@ElementCollection(targetClass = CustomFieldEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomFieldEnum> customFieldAdditional = new HashSet<>();

}
package org.demo.documentation.multipleselect.colorconst;

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
import org.demo.documentation.multipleselect.colorconst.enums.CustomFieldEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity254 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_254", joinColumns = @JoinColumn(name = "MyEntity254_ID"))
	@ElementCollection(targetClass = CustomFieldEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomFieldEnum> customField = new HashSet<>();

}
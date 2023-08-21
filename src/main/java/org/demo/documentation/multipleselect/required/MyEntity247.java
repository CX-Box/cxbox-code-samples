package org.demo.documentation.multipleselect.required;

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
import org.demo.documentation.multipleselect.required.enums.CustomFieldEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity247 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_247", joinColumns = @JoinColumn(name = "MyEntity247_ID"))
	@ElementCollection(targetClass = CustomFieldEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomFieldEnum> customField = new HashSet<>();

}
package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.enums.StatusEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3238 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String fullName;
	@Column
	private String address;
	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEnum status;
}
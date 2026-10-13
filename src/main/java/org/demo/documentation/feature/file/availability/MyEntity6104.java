package org.demo.documentation.feature.file.availability;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.file.availability.enums.StatusEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity6104 extends BaseEntity {

	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEnum status;
}

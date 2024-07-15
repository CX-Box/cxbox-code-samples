package org.demo.documentation.fields.datetimewithseconds.validationannotation;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity167 extends BaseEntity {

	@Column
	private LocalDateTime customField;

}
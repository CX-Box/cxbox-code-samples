package org.demo.documentation.datetime.validationruntimeex;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeValidationRuntimeEx
@Entity
@Table(name = "DateTimeValidationRuntimeEx")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeValidationRuntimeEx extends BaseEntity {

	private LocalDateTime customField;

}
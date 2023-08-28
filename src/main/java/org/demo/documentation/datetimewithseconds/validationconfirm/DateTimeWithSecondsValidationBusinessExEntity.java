package org.demo.documentation.datetimewithseconds.validationconfirm;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsValidationBusinessEx
@Entity
@Table(name = "DateTimeWithSecondsValidationBusinessExEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsValidationBusinessExEntity extends BaseEntity {

	private LocalDateTime customField;

}
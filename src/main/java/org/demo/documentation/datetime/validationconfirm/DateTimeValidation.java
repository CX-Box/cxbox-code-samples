package org.demo.documentation.datetime.validationconfirm;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeValidation
@Entity
@Table(name = "DateTimeValidation")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeValidation extends BaseEntity {

	private LocalDateTime customField;

}
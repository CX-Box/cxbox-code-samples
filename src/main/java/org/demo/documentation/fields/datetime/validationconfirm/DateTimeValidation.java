package org.demo.documentation.fields.datetime.validationconfirm;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
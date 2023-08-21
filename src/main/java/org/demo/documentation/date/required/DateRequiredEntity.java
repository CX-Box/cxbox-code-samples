package org.demo.documentation.date.required;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateRequired
@Entity
@Table(name = "DateRequiredEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateRequiredEntity extends BaseEntity {

	private LocalDate customField;

}
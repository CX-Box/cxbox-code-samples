package org.demo.documentation.date.ro;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateCreateEdit
@Entity
@Table(name = "DateCreateEditEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateCreateEditEntity extends BaseEntity {

	private LocalDate customField;

}
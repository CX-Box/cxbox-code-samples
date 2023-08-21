package org.demo.documentation.date.placeholder;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


//datePlaceholder
@Entity
@Table(name = "DatePlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class DatePlaceholderEntity extends BaseEntity {


	@Column
	private LocalDate customField;

}
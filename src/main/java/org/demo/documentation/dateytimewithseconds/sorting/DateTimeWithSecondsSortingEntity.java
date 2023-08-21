package org.demo.documentation.dateytimewithseconds.sorting;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsSorting
@Entity
@Table(name = "DateTimeWithSecondsSortingEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsSortingEntity extends BaseEntity {

	private LocalDateTime customField;

}
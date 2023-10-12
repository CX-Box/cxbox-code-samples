package org.demo.documentation.date.sorting;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateSortingEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateSortingEntity extends BaseEntity {

	private LocalDateTime  customField;

}
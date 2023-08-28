package org.demo.documentation.datetime.sorting;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

;

//dateTimeSort
@Entity
@Table(name = "DateTimeSort")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeSort extends BaseEntity {

	private LocalDateTime customField;

}
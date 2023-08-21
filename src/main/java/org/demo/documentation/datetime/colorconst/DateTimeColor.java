package org.demo.documentation.datetime.colorconst;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeColor
@Entity
@Table(name = "DateTimeColor")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeColor extends BaseEntity {

	private LocalDateTime customField;

}
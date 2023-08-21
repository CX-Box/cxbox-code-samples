package org.demo.documentation.datetime.filtration;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "DateTimeFiltration")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeFiltration extends BaseEntity {

	private LocalDateTime customField;

}
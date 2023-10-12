package org.demo.documentation.date.color;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "dateColor")
@Getter
@Setter
@NoArgsConstructor
public class dateColor extends BaseEntity {

	private LocalDateTime  customField;

}
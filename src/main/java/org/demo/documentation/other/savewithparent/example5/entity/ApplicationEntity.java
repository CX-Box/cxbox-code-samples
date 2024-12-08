package org.demo.documentation.other.savewithparent.example5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "APPLICATION_ENTITY")
public class ApplicationEntity extends BaseEntity {

	@Column
	private String name;

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEnum status;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationEntityId")
	private List<Task> tasksId;

}

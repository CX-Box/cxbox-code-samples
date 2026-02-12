package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject.enums.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "NAME_F_S_P_P_ID")
	@ManyToOne
	private MyEntity4903Pick nameFSPPEntity;
	@Enumerated(value = EnumType.STRING)
	@Column
	private PlacePresentationEnum placePresentation;
	@JoinColumn(name = "NAME_O_S_P_ID")
	@ManyToOne
	private MyEntity4903OCPPick nameOSPEntity;
	@Enumerated(value = EnumType.STRING)
	@Column
	private ObjectTypeEnum objectType;
	@Enumerated(value = EnumType.STRING)
	@Column
	private FileTypeEnum fileType;
	@JoinColumn(name = "INSTANCE_ID")
	@ManyToOne
	private MyEntity4903Instance instanceEntity;
	@Column
	private String file;
	@Column
	private String fileId;
	@Enumerated(value = EnumType.STRING)
	@Column
	private ChannelEnum channel;
	@Enumerated(value = EnumType.STRING)
	@Column
	private UsersNameEnum usersName;
	@JoinColumn(name = "NAME_FILE_ID")
	@ManyToOne
	private MyEntity4903FileNamePick nameFileEntity;
}

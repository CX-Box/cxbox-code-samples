package org.demo.documentation.fields.property.snapshotkey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5900PickRepository extends JpaRepository<MyEntity5900Pick, Long>,
		JpaSpecificationExecutor<MyEntity5900Pick> {

}

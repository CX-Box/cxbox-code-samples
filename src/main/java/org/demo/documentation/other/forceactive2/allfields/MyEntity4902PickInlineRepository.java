package org.demo.documentation.other.forceactive2.allfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4902PickInlineRepository extends JpaRepository<MyEntity4902PickInline, Long>, JpaSpecificationExecutor<MyEntity4902PickInline> {

}

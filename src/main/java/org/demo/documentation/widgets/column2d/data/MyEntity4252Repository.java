package org.demo.documentation.widgets.column2d.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4252Repository extends JpaRepository<MyEntity4252, Long>, JpaSpecificationExecutor<MyEntity4252> {

	// --8<-- [start:clientSums]
	@Query("""
			SELECT new org.demo.documentation.widgets.column2d.data.ClientSum4252(
			min(e.id), e.clientName, sum(e.amount), count(e.id))
			FROM MyEntity4252 e
			GROUP BY e.clientName
			ORDER BY e.clientName
			""")
	List<ClientSum4252> getClientSums();
	// --8<-- [end:clientSums]

	// --8<-- [start:clientProductSums]
	@Query("""
			SELECT new org.demo.documentation.widgets.column2d.data.ClientProductSum4252(
			min(e.id), e.clientName, e.product, sum(e.amount))
			FROM MyEntity4252 e
			GROUP BY e.clientName, e.product
			ORDER BY e.clientName, e.product
			""")
	List<ClientProductSum4252> getClientProductSums();
	// --8<-- [end:clientProductSums]

}

package org.demo.documentation.other.assoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface LegalCaseDocumentsRepository extends JpaRepository<LegalCaseDocuments, Long>, JpaSpecificationExecutor<LegalCaseDocuments> {


}

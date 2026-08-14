package org.demo.repository.core;

import org.demo.documentation.widgets.tree.any.data.users.My3261Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface My3261UsersRepository extends JpaRepository<My3261Users, Long>, JpaSpecificationExecutor<My3261Users> {


}

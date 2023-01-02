package hr.ericsson.hrm.controllers.repository.core;

import org.springframework.data.repository.CrudRepository;

import hr.ericsson.hrm.controllers.domain.core.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}

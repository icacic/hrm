package hr.ericsson.hrm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import hr.ericsson.hrm.controllers.domain.core.User;
import hr.ericsson.hrm.controllers.repository.core.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HrmRepositroyTests {    
    @Autowired UserRepository userRepository;

    @Test
    @Rollback(false)
    public void insertUser() {
        User u = User.builder()
                    .firstName("Ilija")
                    .lastName("Ćaćić")
                    .username("icacic")
                    .status(true)
                    .createdDate(new Date())
                    .lastUpdatedDate(new Date())
                    .build();

        u = userRepository.save(u);
        assertTrue(u.getId() > 0);            
    }

}

package jobfinder.modules.authentication;

import jobfinder.common.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jiaweizhang on 2/29/2016.
 */

@Transactional
@Service
public class AuthService {
    @Autowired
    private JdbcTemplate jt;

    public StandardResponse login(UserRequest req) {
        return new StandardResponse(true, "attempting login");
    }
}

package jobfinder.modules.authentication;

/**
 * Created by jiaweizhang on 2/29/2016.
 */

import jobfinder.common.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public StandardResponse login(@RequestBody final UserRequest req) {
        return authService.login(req);
    }

}



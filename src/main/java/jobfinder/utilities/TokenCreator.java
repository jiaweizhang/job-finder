package jobfinder.utilities;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by jiaweizhang on 2/29/2016.
 */
public class TokenCreator {
    public static String generateToken(String email) {
        String jwt = Jwts.builder().setSubject(email)
                .claim("email", email)
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        return jwt;
    }


}

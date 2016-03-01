package jobfinder.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jiaweizhang on 2/29/2016.
 */
public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            createResponse(res, "Missing Authorization header");
            return;
        } else if (!authHeader.startsWith("Bearer ")) {
            createResponse(res, "Invalid Authorization header");
            return;
        }
        final String token = authHeader.substring(7);
        try {
            final Claims claims = Jwts.parser().setSigningKey("secretkey")
                    .parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
        } catch (Exception f) {
            createResponse(res, "Invalid token");
            return;
        }

        chain.doFilter(req, res);
    }

    private void createResponse(ServletResponse res, String message) {
        try {
            PrintWriter out = res.getWriter();
            CharArrayWriter caw = new CharArrayWriter();
            caw.write(createJson(message));
            res.setContentType("application/json;charset=UTF-8"); // must be before close
            out.write(caw.toString());
            out.close();
        } catch (IOException ignored) {
        }
    }

    public String createJson(String message) {
        ObjectMapper mapper = new ObjectMapper();
        StandardResponse response = new StandardResponse(true, message);
        try {
            return mapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }
}
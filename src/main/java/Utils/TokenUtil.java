package Utils;


import com.ttuan.Define.SystemConstant;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final String kCREATEUSERNAME = "CreateUserName";
    private static final String kCREATETIME = "CreateTime";
    private String secret;

    private Long expiration;
    /**
     * 签发JWT
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @return  String
     *
     */
    public static String createJWT(String id, String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setClaims(generateClaims(id))
                .setSubject(subject)   // 主题
                .setIssuer("user")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, SystemConstant.SECRET); // 签名算法以及密匙
        if (SystemConstant.EXPIRATION >= 0) {
            long expMillis = nowMillis + SystemConstant.EXPIRATION;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }
    public static String refreshToken(String token){
        String refreshedToken;
        try {
            Claims claims = parseJWT(token);
            claims.put(kCREATETIME, new Date());
            String uid = claims.get(kCREATEUSERNAME).toString();
            String userName = claims.get(kCREATEUSERNAME).toString();
            System.out.println(uid);
            System.out.println(userName);
            refreshedToken = createJWT(uid,userName);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public static Map<String, Object> generateClaims(String id) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(kCREATEUSERNAME, id);
        claims.put(kCREATETIME, new Date(System.currentTimeMillis()));
        return claims;
    }



    public static void verifyToken(String token) {
        Claims claims;
        try {
             claims = parseJWT(token);
             System.out.println(claims);
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public static Claims parseJWT(String jwt) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SystemConstant.SECRET)
                    .parseClaimsJws(jwt)
                    .getBody();
        }catch (Exception e) {
            throw e;
        }
        return claims;
    }
    /**
     * 获取jwt失效时间
     */
    public Date getExpirationDateFromToken(String token) {
        return parseJWT(token).getExpiration();
    }

}

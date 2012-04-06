package authtoken;

import play.api.libs.Crypto;
import play.mvc.Http.Context;

public class AuthenticityTokenGenerator {

	/**
	 * Generates a UUID and stores its signature in the session, used by the authenticity token
	 * @return
	 */
	public static String generate() {
		String uuid=java.util.UUID.randomUUID().toString();
		String sign=Crypto.sign(uuid);
		Context.current().session().put(AuthTokenConstants.AUTH_TOKEN, sign);
		return uuid;
	}
	
}

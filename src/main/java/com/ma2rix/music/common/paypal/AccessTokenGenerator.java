package com.ma2rix.music.common.paypal;

import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;

public class AccessTokenGenerator {
	
	public static final String CLIENT_ID = "";
	public static final String CLIENT_SECRET = "";
	
	private static String accessToken;

	public static String getAccessToken() throws PayPalRESTException {
		if (accessToken == null) {
			accessToken = new OAuthTokenCredential(CLIENT_ID, CLIENT_SECRET).getAccessToken();
		}
		return accessToken;
	}
}

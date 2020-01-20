package com.vrs.util;

import java.util.Locale;
import java.util.ResourceBundle;


import com.vrs.constants.Constants;
import com.vrs.constants.ErrorConstants;
import com.vrs.constants.SuccessConstants;


public final class PropertyUtil {

	private PropertyUtil(){
		new PropertyUtil();
	}
	
	private static ResourceBundle getBundles(
			final String filename) {
		final Locale currentLocale = Locale.getDefault();
		return ResourceBundle.getBundle(filename, currentLocale);

	}

	public static String getSuccessMessage(final String key) {
		final ResourceBundle messages = getBundles(SuccessConstants.SUCCESSMESSAGES);
		return messages.getString(key);

	}

	public static String getErrorMessage(final String key) {
		final ResourceBundle messages = getBundles(ErrorConstants.ERRORMESSAGES);
		return messages.getString(key);

	}
	
	public static String getUIText(final String label) {
		final ResourceBundle bundle = getBundles(Constants.UITEXT);
		return bundle.getString(label);

	}


	

}

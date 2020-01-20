package com.vrs.bo;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.StringTokenizer;


/**
 * The Class ValidationsBO
 * this class contains all the business validations
 */
public class ValidationsBO {

	/**
	 * Check user id.
	 * this is a user id validation which says user id shoud contain only numbers and must be 6 in lenghh
	 * @param uid the uid
	 * @return the int
	 */
	public static int checkUserId(String uid) {
		if (uid.length() == 6) {
			int flag = 0;
			for (int i = 0; i < uid.length(); i++) {
				if (Character.isDigit(uid.charAt(i))) {
					flag++;
				}
			}
			if (flag == uid.length()) {
				return Integer.parseInt(uid);
			} else {
				return 0;
			}
		} else {
			return 0;
		}

	}

	/**
	 * Check name.
	 * this is a name validation which says name shoud contain only alphabets
	 * @param name the name
	 * @return the string
	 */
	public static String checkName(String name) {

		if (name.length() > 0) {
			int flag = 0;
			for (int i = 0; i < name.length(); i++) {
				if (Character.isAlphabetic(name.charAt(i))) {
					flag++;
				}
			}
			if (flag == name.length()) {
				return name;
			} else {
				return "f";
			}
		} else {
			return "f";
		}
	}

	
	/**
	 * Check password.
	 * this is method for password validation
	 * @param password the password
	 * @return the string
	 */
	public static String checkPassword(String password) {

		if (password.length() >= 8 && password.length() <= 20) {
			String a = "!@#$%^&*()?<>~";
			int flag = 0, sc = 0;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isDigit(password.charAt(i)))
					flag++;

			}
			for (int i = 0; i < password.length(); i++) {
				for (int j = 0; j < a.length(); j++) {
					if (password.charAt(i) == (a.charAt(j)))
						sc++;
				}
			}

			if (flag > 0 && sc > 0)
				return password;
			else
				return "f";
		} else {
			return "f";

		}

	}

	
	/**
	 * Check branch.
	 * this is method for branch validation
	 * @param Bloc the bloc
	 * @return the string
	 */
	public static String checkBranch(String Bloc) {
		if (Bloc.length() > 0) {
			int flag = 0;
			for (int i = 0; i < Bloc.length(); i++) {
				if (Character.isAlphabetic(Bloc.charAt(i))
				|| Character.isDigit((Bloc.charAt(i)))) {
					flag++;
				}
			}

			if (flag == Bloc.length()) {
				return Bloc;
			} else {
				return "f";
			}
		} else {
			return "f";
		}
	}

	
	
	/**
	 * Check dob.
	 * this is method for date of birth validation
	 * @param date the date
	 * @return the string
	 */
	public static String checkDob(String date) {

		if (date.length() > 0) {

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
				Date d = sdf.parse(date);
				Date cd = new Date();
				if (sdf.format(d).equals(sdf.format(cd))) {
					return "f";
				} else {
					Calendar c = Calendar.getInstance();
					Calendar c1 = Calendar.getInstance();
					c.setTime(d);
					long i = c.getTimeInMillis();
					c1.setTime(cd);
					long j = c1.getTimeInMillis();
					long days = (j - i) / (3600 * 1000 * 24);
					float age = (float) (days / 365.0);
					if (age > 20) {
						return date;
					} else {
						return "f";
					}
				}

			} catch (Exception e) {
				return "f";
			}

		} else {
			return "f";
		}
	}

	
	
	/**
	 * Check email.
	 * this is method for Email validation
	 * @param email the email
	 * @return the string
	 */
	public static String checkEmail(String email) {

		int atpos = email.indexOf("@");
		int dotpos = email.lastIndexOf(".");
		if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length()) {
			System.out.println("Not a valid e-mail address");
			return "f";
		} else {
			return email;
		}
	}

	
	/**
	 * Check phone.
	 * this is method for phone validation
	 * @param phone the phone
	 * @return the string
	 */
	public static String checkPhone(String phone) {

		int flag = 0;
		if (!phone.contains("-"))
			return "f";
		else {
			try{
			StringTokenizer st = new StringTokenizer(phone, "-");
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			if (phone.length() == 11) {
				if (s1.length() == 3 && s2.length() == 7) {
				String s3 = s1 + s2;
					if (s3.length() == 10) {
						return phone;
					} else {
						return "f";
					}
				} else
					return "f";
			} else {
				return "f";
			}
		}
		catch(Exception e)
		{
			return "f";
		}
	}
	}
}

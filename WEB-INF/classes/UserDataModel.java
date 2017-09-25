/**
 * 
 */
package chapter4.session.practice;

import java.util.*;

/**
 * @author EwacEbup
 *
 */
public class UserDataModel {
	
	private HashMap<String, String> userData;
	
	public UserDataModel() {
		userData = new HashMap<>();
		userData.put("testuser1", "testuser1".hashCode() + "");
		userData.put("testuser2", "testuser2".hashCode() + "");
		userData.put("testuser3", "testuser3".hashCode() + "");
	}
	
	public int verifyUserCredentials(String username, String password) {
		for (Map.Entry<String, String> entry : userData.entrySet()) {
			if (entry.getKey().equals(username)) {
				if (entry.getValue().equals(password)) {
					return 0;
				}
				else {
					return 1;
				}
			}
		}
		return 2;
	}
		
}
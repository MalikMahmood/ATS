// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oidc.actions;

import communitycommons.StringUtils;
import java.security.MessageDigest;
import java.util.Base64;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * Hashes a value using the SHA-256 hash algorithm. 
 * 
 * - value : the value to hash
 * - length : the desired length of the hash. 
 * 
 * Returns a SHA-256 hash of 'value', with length 'length'
 */
public class GetCodeChallenge extends CustomJavaAction<java.lang.String>
{
	private java.lang.String codeVerifier;

	public GetCodeChallenge(IContext context, java.lang.String codeVerifier)
	{
		super(context);
		this.codeVerifier = codeVerifier;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		byte[] bytes = codeVerifier.getBytes("US-ASCII");
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    messageDigest.update(bytes, 0, bytes.length);
	    byte[] digest = messageDigest.digest();
	    return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetCodeChallenge";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

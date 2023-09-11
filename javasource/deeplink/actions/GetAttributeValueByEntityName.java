// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package deeplink.actions;

import java.util.List;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class GetAttributeValueByEntityName extends CustomJavaAction<java.lang.String>
{
	private java.lang.String Entity;
	private java.lang.String AttributeName;

	public GetAttributeValueByEntityName(IContext context, java.lang.String Entity, java.lang.String AttributeName)
	{
		super(context);
		this.Entity = Entity;
		this.AttributeName = AttributeName;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE

		try {
			List<IMendixObject> list = Core.createXPathQuery(String.format("//%s",Entity))
				.setOffset(0)
				.setAmount(1)
				.execute(getContext());
			
			return list.size()==1 ? list.get(0).getValue(getContext(), AttributeName).toString() : null;

		}
		catch (Exception e) {
			Core.getLogger(deeplink.implementation.Commons.logNodeName).warn("Unable to retrieve a random object for entity '" + Entity + "'");
			throw(e);
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetAttributeValueByEntityName";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

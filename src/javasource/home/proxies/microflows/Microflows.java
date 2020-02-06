// This file was generated by Mendix Modeler 7.23.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package home.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;

public class Microflows
{
	// These are the microflows for the Home module
	public static void iVK_Home_SendMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			Core.execute(context, "Home.IVK_Home_SendMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_TestMessage_SendToSlack(IContext context, home.proxies.TestMessage _testMessage, slackmessage.proxies.Message _message)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("TestMessage", _testMessage == null ? null : _testMessage.getMendixObject());
			params.put("Message", _message == null ? null : _message.getMendixObject());
			Core.execute(context, "Home.IVK_TestMessage_SendToSlack", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}
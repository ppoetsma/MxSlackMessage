// This file was generated by Mendix Modeler 7.23.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package slackmessage.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the SlackMessage module
	public static void aSu_SlackMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			Core.execute(context, "SlackMessage.ASu_SlackMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean bCo_IncomingWebhook(IContext context, slackmessage.proxies.IncomingWebhook _incomingWebhook)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhook", _incomingWebhook == null ? null : _incomingWebhook.getMendixObject());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.BCo_IncomingWebhook", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean bCo_SlackApp(IContext context, slackmessage.proxies.SlackApp _slackApp)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlackApp", _slackApp == null ? null : _slackApp.getMendixObject());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.BCo_SlackApp", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.lang.String cal_SlackApp_SlackConfigUrl(IContext context, slackmessage.proxies.SlackApp _slackApp)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlackApp", _slackApp == null ? null : _slackApp.getMendixObject());
			return (java.lang.String)Core.execute(context, "SlackMessage.Cal_SlackApp_SlackConfigUrl", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.lang.String commandHealth_DoTheMagic(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			return (java.lang.String)Core.execute(context, "SlackMessage.CommandHealth_DoTheMagic", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.Enum_TextType convert_Mrkdwn_TextType(IContext context, boolean _mrkdwn)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Mrkdwn", _mrkdwn);
			java.lang.String result = (java.lang.String)Core.execute(context, "SlackMessage.Convert_Mrkdwn_TextType", params);
			if (result == null)
				return null;
			return slackmessage.proxies.Enum_TextType.valueOf(result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean convert_TextType_Mrkdwn(IContext context, slackmessage.proxies.Enum_TextType _textType)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("TextType", _textType == null ? null : _textType.name());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.Convert_TextType_Mrkdwn", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.lang.String decryptString(IContext context, java.lang.String _stringToDecrypt)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("StringToDecrypt", _stringToDecrypt);
			return (java.lang.String)Core.execute(context, "SlackMessage.DecryptString", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.lang.String encryptionPrefix_SlackAES(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			return (java.lang.String)Core.execute(context, "SlackMessage.EncryptionPrefix_SlackAES", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.lang.String encryptString(IContext context, java.lang.String _stringToEncrypt)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("StringToEncrypt", _stringToEncrypt);
			return (java.lang.String)Core.execute(context, "SlackMessage.EncryptString", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static system.proxies.HttpHeader httpHeaderList_FindHeader(IContext context, java.lang.String _key, java.util.List<system.proxies.HttpHeader> _httpHeaderList, slackmessage.proxies.SlashCommandRequest _slashCommandRequest, boolean _isRequired)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Key", _key);
			java.util.ArrayList<IMendixObject> listparam_httpHeaderList = null;
			if (_httpHeaderList != null)
			{
				listparam_httpHeaderList = new java.util.ArrayList<IMendixObject>();
				for (system.proxies.HttpHeader obj : _httpHeaderList)
					listparam_httpHeaderList.add(obj.getMendixObject());
			}
			params.put("HttpHeaderList", listparam_httpHeaderList);
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			params.put("IsRequired", _isRequired);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.HttpHeaderList_FindHeader", params);
			return result == null ? null : system.proxies.HttpHeader.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.IncomingWebhook incomingWebhook_Ensure(IContext context, java.lang.String _label, java.lang.String _key, java.lang.String _uRL)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Label", _label);
			params.put("Key", _key);
			params.put("URL", _uRL);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.IncomingWebhook_Ensure", params);
			return result == null ? null : slackmessage.proxies.IncomingWebhook.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.IncomingWebhook incomingWebhook_RetrieveByKey(IContext context, java.lang.String _incomingWebhookKey, boolean _autoCreate)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhookKey", _incomingWebhookKey);
			params.put("AutoCreate", _autoCreate);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.IncomingWebhook_RetrieveByKey", params);
			return result == null ? null : slackmessage.proxies.IncomingWebhook.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.IncomingWebhook incomingWebhook_Upsert(IContext context, java.lang.String _label, java.lang.String _key, java.lang.String _uRL)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Label", _label);
			params.put("Key", _key);
			params.put("URL", _uRL);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.IncomingWebhook_Upsert", params);
			return result == null ? null : slackmessage.proxies.IncomingWebhook.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean incomingWebhook_Validate(IContext context, slackmessage.proxies.IncomingWebhook _incomingWebhook)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhook", _incomingWebhook == null ? null : _incomingWebhook.getMendixObject());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.IncomingWebhook_Validate", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_IncomingWebhook_New(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			Core.execute(context, "SlackMessage.IVK_IncomingWebhook_New", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_IncomingWebhook_Save(IContext context, slackmessage.proxies.IncomingWebhook _incomingWebhook)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhook", _incomingWebhook == null ? null : _incomingWebhook.getMendixObject());
			Core.execute(context, "SlackMessage.IVK_IncomingWebhook_Save", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_IncomingWebhook_SendTestMessage(IContext context, slackmessage.proxies.IncomingWebhook _incomingWebhook)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhook", _incomingWebhook == null ? null : _incomingWebhook.getMendixObject());
			Core.execute(context, "SlackMessage.IVK_IncomingWebhook_SendTestMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_IncomingWebhook_SendTestMessageNotification(IContext context, slackmessage.proxies.IncomingWebhook _incomingWebhook)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhook", _incomingWebhook == null ? null : _incomingWebhook.getMendixObject());
			Core.execute(context, "SlackMessage.IVK_IncomingWebhook_SendTestMessageNotification", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_IncomingWebhookList_Encrypt(IContext context, java.util.List<slackmessage.proxies.IncomingWebhook> _incomingWebhookList)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			java.util.ArrayList<IMendixObject> listparam_incomingWebhookList = null;
			if (_incomingWebhookList != null)
			{
				listparam_incomingWebhookList = new java.util.ArrayList<IMendixObject>();
				for (slackmessage.proxies.IncomingWebhook obj : _incomingWebhookList)
					listparam_incomingWebhookList.add(obj.getMendixObject());
			}
			params.put("IncomingWebhookList", listparam_incomingWebhookList);
			Core.execute(context, "SlackMessage.IVK_IncomingWebhookList_Encrypt", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SlackApp_Save(IContext context, slackmessage.proxies.SlackApp _slackApp)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlackApp", _slackApp == null ? null : _slackApp.getMendixObject());
			Core.execute(context, "SlackMessage.IVK_SlackApp_Save", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void message_AddLine(IContext context, slackmessage.proxies.Message _message, slackmessage.proxies.Enum_TextType _textType, java.lang.String _messageText)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Message", _message == null ? null : _message.getMendixObject());
			params.put("TextType", _textType == null ? null : _textType.name());
			params.put("MessageText", _messageText);
			Core.execute(context, "SlackMessage.Message_AddLine", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.Message message_Create(IContext context, java.lang.String _notificationText, slackmessage.proxies.Enum_TextType _textType)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("NotificationText", _notificationText);
			params.put("TextType", _textType == null ? null : _textType.name());
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.Message_Create", params);
			return result == null ? null : slackmessage.proxies.Message.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean message_CreateAndSendToWebhookKey(IContext context, java.lang.String _notificationText, slackmessage.proxies.Enum_TextType _notificationTextType, java.lang.String _messageText, slackmessage.proxies.Enum_TextType _messageTextType, java.lang.String _incomingWebhookKey, boolean _sendAsync)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("NotificationText", _notificationText);
			params.put("NotificationTextType", _notificationTextType == null ? null : _notificationTextType.name());
			params.put("MessageText", _messageText);
			params.put("MessageTextType", _messageTextType == null ? null : _messageTextType.name());
			params.put("IncomingWebhookKey", _incomingWebhookKey);
			params.put("SendAsync", _sendAsync);
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.Message_CreateAndSendToWebhookKey", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean message_CreateAndSendToWebhookURL(IContext context, java.lang.String _notificationText, slackmessage.proxies.Enum_TextType _notificationTextType, java.lang.String _messageText, slackmessage.proxies.Enum_TextType _messageTextType, java.lang.String _incomingWebhookURL, boolean _sendAsync)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("NotificationText", _notificationText);
			params.put("NotificationTextType", _notificationTextType == null ? null : _notificationTextType.name());
			params.put("MessageText", _messageText);
			params.put("MessageTextType", _messageTextType == null ? null : _messageTextType.name());
			params.put("IncomingWebhookURL", _incomingWebhookURL);
			params.put("SendAsync", _sendAsync);
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.Message_CreateAndSendToWebhookURL", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.lang.String message_ExportToJSON(IContext context, slackmessage.proxies.Message _message)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Message", _message == null ? null : _message.getMendixObject());
			return (java.lang.String)Core.execute(context, "SlackMessage.Message_ExportToJSON", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean message_SendToWebhookKey(IContext context, java.lang.String _incomingWebhookKey, slackmessage.proxies.Message _message, boolean _sendAsync)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhookKey", _incomingWebhookKey);
			params.put("Message", _message == null ? null : _message.getMendixObject());
			params.put("SendAsync", _sendAsync);
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.Message_SendToWebhookKey", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean message_SendToWebhookURL(IContext context, java.lang.String _incomingWebhookURL, slackmessage.proxies.Message _message, boolean _sendAsync)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhookURL", _incomingWebhookURL);
			params.put("Message", _message == null ? null : _message.getMendixObject());
			params.put("SendAsync", _sendAsync);
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.Message_SendToWebhookURL", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void pRS_SlashCommand_AnyCommand(IContext context, system.proxies.HttpRequest _httpRequest, system.proxies.HttpResponse _httpResponse)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("httpRequest", _httpRequest == null ? null : _httpRequest.getMendixObject());
			params.put("httpResponse", _httpResponse == null ? null : _httpResponse.getMendixObject());
			Core.execute(context, "SlackMessage.PRS_SlashCommand_AnyCommand", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sE_SendToSlackHelper_Cleanup(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			Core.execute(context, "SlackMessage.SE_SendToSlackHelper_Cleanup", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.SendToSlackHelper sendToSlackHelper_Create(IContext context, java.lang.String _incomingWebhookString, slackmessage.proxies.Enum_IncomingWebhook_Type _incomingWebhookType, slackmessage.proxies.Message _message, boolean _persist, boolean _sendAsync)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("IncomingWebhookString", _incomingWebhookString);
			params.put("IncomingWebhookType", _incomingWebhookType == null ? null : _incomingWebhookType.name());
			params.put("Message", _message == null ? null : _message.getMendixObject());
			params.put("Persist", _persist);
			params.put("SendAsync", _sendAsync);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.SendToSlackHelper_Create", params);
			return result == null ? null : slackmessage.proxies.SendToSlackHelper.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sendToSlackHelper_Post(IContext context, slackmessage.proxies.SendToSlackHelper _sendToSlackHelper)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SendToSlackHelper", _sendToSlackHelper == null ? null : _sendToSlackHelper.getMendixObject());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.SendToSlackHelper_Post", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sendToSlackHelper_Send(IContext context, slackmessage.proxies.SendToSlackHelper _sendToSlackHelper)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SendToSlackHelper", _sendToSlackHelper == null ? null : _sendToSlackHelper.getMendixObject());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.SendToSlackHelper_Send", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.SlackApp slackApp_Ensure(IContext context, java.lang.String _name, java.lang.String _appID, java.lang.String _signingSecret)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Name", _name);
			params.put("AppID", _appID);
			params.put("SigningSecret", _signingSecret);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.SlackApp_Ensure", params);
			return result == null ? null : slackmessage.proxies.SlackApp.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.SlackApp slackApp_Upsert(IContext context, java.lang.String _name, java.lang.String _appID, java.lang.String _signingSecret)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Name", _name);
			params.put("AppID", _appID);
			params.put("SigningSecret", _signingSecret);
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.SlackApp_Upsert", params);
			return result == null ? null : slackmessage.proxies.SlackApp.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean slackApp_Validate(IContext context, slackmessage.proxies.SlackApp _slackApp)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlackApp", _slackApp == null ? null : _slackApp.getMendixObject());
			return (java.lang.Boolean)Core.execute(context, "SlackMessage.SlackApp_Validate", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommand_Log(IContext context, slackmessage.proxies.SlashCommandRequest _slashCommandRequest, communitycommons.proxies.LogLevel _logLevel, java.lang.String _message)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			params.put("LogLevel", _logLevel == null ? null : _logLevel.name());
			params.put("Message", _message);
			Core.execute(context, "SlackMessage.SlashCommand_Log", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.SlashCommandRequest slashCommandRequest_Create(IContext context, system.proxies.HttpRequest _httpRequest, system.proxies.HttpResponse _httpResponse)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("HttpRequest", _httpRequest == null ? null : _httpRequest.getMendixObject());
			params.put("HttpResponse", _httpResponse == null ? null : _httpResponse.getMendixObject());
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.SlashCommandRequest_Create", params);
			return result == null ? null : slackmessage.proxies.SlashCommandRequest.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static slackmessage.proxies.SlashCommandRequest slashCommandRequest_ParseRequestBody(IContext context, system.proxies.HttpRequest _httpRequest, java.lang.String _uUID, system.proxies.HttpResponse _httpResponse)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("HttpRequest", _httpRequest == null ? null : _httpRequest.getMendixObject());
			params.put("UUID", _uUID);
			params.put("HttpResponse", _httpResponse == null ? null : _httpResponse.getMendixObject());
			IMendixObject result = (IMendixObject)Core.execute(context, "SlackMessage.SlashCommandRequest_ParseRequestBody", params);
			return result == null ? null : slackmessage.proxies.SlashCommandRequest.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandRequest_ParseRequestHeaders(IContext context, system.proxies.HttpRequest _httpRequest, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("HttpRequest", _httpRequest == null ? null : _httpRequest.getMendixObject());
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandRequest_ParseRequestHeaders", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandRequest_ProcessAnyCommand(IContext context, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandRequest_ProcessAnyCommand", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandRequest_ProcessHealthCommand(IContext context, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandRequest_ProcessHealthCommand", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandRequest_Validate(IContext context, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandRequest_Validate", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandResponse_Create(IContext context, java.lang.String _message, slackmessage.proxies.Enum_SlashCommand_ResponseVisibility _channelVisibility, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Message", _message);
			params.put("ChannelVisibility", _channelVisibility == null ? null : _channelVisibility.name());
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandResponse_Create", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandResponse_Create_VisibilityChannel(IContext context, java.lang.String _message, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Message", _message);
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandResponse_Create_VisibilityChannel", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void slashCommandResponse_Create_VisibilityUser(IContext context, java.lang.String _message, slackmessage.proxies.SlashCommandRequest _slashCommandRequest)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("Message", _message);
			params.put("SlashCommandRequest", _slashCommandRequest == null ? null : _slashCommandRequest.getMendixObject());
			Core.execute(context, "SlackMessage.SlashCommandResponse_Create_VisibilityUser", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}
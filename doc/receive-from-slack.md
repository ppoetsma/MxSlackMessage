# Receive commands

## Create a Slack App

Use the [Slack API documentation](https://api.slack.com/interactivity/slash-commands) to create a Slack App. Once created you can [manage the app](https://api.slack.com/apps) and for example add commands.

Next step is to make the new Slack App available in your Mendix app. To do that use snippet `SN_SlackApp` to add the data manually or use microflows `SlackApp_Upsert` or `SlackApp_Upsert` to add the data automatically (for example in AfterStartup).

This is what you have to store in your Mendix app:

* **App name** - ideally the name of the Slack App
* **App ID** - copy from the App Credentials section
* **Signing Secret** - copy from the App Credentials section; this value is stored encrypted in the Mendix app's database

You can find this information in menu **Settings - Basic Information** of the Slack App; see the screenshot below.

![App credentials](Slack%20screenshot%205.png)

## Manage slash commands in the Slack App

At the [Slack Your App](https://api.slack.com/apps) page open your app and go to menu **Features - Slash Commands**. The slash commands can be managed here. This is what you have to take into account:

1. Create commands with (optional) parameters that make sense to the user and that are easy to type.
2. Add a proper description to help the user understand what the command does.
3. The request URL has to be provided. This is a to be defined web service in your Mendix app. That will be discussed later.

Slack does not know what the command and parameters should do. It sends them as defined to the Mendix app, expects the app to know what to do and expects a formatted response in return.

![Manage slash commands](Slack%20screenshot%206.png)

![Edit a slash command](Slack%20screenshot%207.png)

## Process slash commands in your Mendix app

The module comes with an example of a request handler (web service) for slash commands. The SlackMessage module cannot provide you with one out of the box because it does not know which commands you will create. The module offers some functions to help processing the request and creating a response. Slash commands can be very powerful and you have to create the microflow to handle that yourself.

See folder **_USE ME slash commands / Example request handler** for an example request handler. It starts at microflow `PRS_SlashCommand_AnyCommand` where the first action calls microflow `SlashCommandRequest_Create` to validate the request and convert it into useable data.

The request is validated on these aspects:

* It is technically a slash command request from Slack.
* The Slack App is found in your Mendix app's database, so the request is authorized.

After validation an object of type `SlashCommandRequest` is available. The following attributes can be used to decide what to do next:

| Attribute        | Documentation                                                                                           |
| ---------------- | ------------------------------------------------------------------------------------------------------- |
| `IsValidRequest` | Is this a valid request? See below for the `Enum_SlashCommandRequest_ValidRequest` enumeration values.  |
| `SlackAppName`   | The name of the app as defined in your Mendix app                                                       |
| `Command`        | The command including the slash.                                                                        |
| `Text`           | Optionally the command parameter(s).                                                                    |
| `SlackTimestamp` | The timestamp of the request, according to Slack. This is used to validate if this is a recent request. |
| `SlackUserAgent` | The user-agent request header.                                                                          |
| `UUID`           | An unique UUID for this request; this SlackMessage module generates it and uses it in logging.          |

The entity has more attributes than listed above. See the entity and [the Slack documentationa](https://api.slack.com/interactivity/slash-commands) for the details. Depending on your specific setup attributes have a value or not, that is controlled by Slack.

The values of enumeration `Enum_SlashCommandRequest_ValidRequest` are:

| Attribute          | Documentation                                                                                                                                                                          |
| ------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `ok`               | The request is valid.                                                                                                                                                                  |
| `oksslcheck`       | The request is valid but can be ignored, see below regarding **SSL Check**.                                                                                                            |
| `invalid`          | The request is not valid.                                                                                                                                                              |
| `invalidsslcheck`  | The request is not valid but can be ignored, see below regarding **SSL Check**. Nevertheless something to look at because one might expect that this automatic request is a valid one. |
| `unknownsignature` | The request was signed using a **Signing Secret** unknown to the Mendix app. Solve this by configuring the Slack App in your Mendix app, see above for instructions.                   |
| `missingheaders`   | The request headers were (partially) missing.                                                                                                                                          |
| `invalidtimestamp` | The request was too old.                                                                                                                                                               |

Your microflow should only continue on value `ok`, or outcome TRUE per rule `Rule_SlashCommandRequest_IsValid`. In all other cases simply stop; the response to Slack is already created for you so don't worry about that.

Slack sends so called **SSL Check** requests to public apps to validate the server's certificate. Your Mendix app can ignore these requests, they are handled by the module. See also [the Slack documentation for details](https://api.slack.com/interactivity/slash-commands#app_command_handling). When your Slack App is not public then these requests are not made.

The next and last step is to process the command and create a response. What "process the command" means is up to your use case(s). In the end use microflow `SlashCommandResponse_Create` to create the response to be send back. This is what the parameters mean:

* `Message` - The message to show in the channel. Emoji's are allowed here, for example *Don't know :confused:*
* `ChannelVisibility` - See enumeration `Enum_SlashCommand_ResponseVisibility` below.
* `SlashCommandRequest` - The Mendix `HttpResponse` object is associated to this one. So in your process you only have to drag the `SlashCommandRequest` object around. The  module will take care of the technical web service details as much as possible.

Enumeration `Enum_SlashCommand_ResponseVisibility` tells Slack who to show the message to:

* `ephemeral` - only to the user who issued the command
* `in_channel` - to everybody in the channel

## Documents

### Microflows

| Microflow                                                    | Function                                                                                                                                                                                     |
| ------------------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `SlackMessage.SlackApp_Ensure`                               | Add a Slack App definition and return it. When already in the database then retrieve that one.                                                                                               |
| `SlackMessage.SlackApp_Upsert`                               | Add a Slack App definition and return it. When already in the database then update it and retrieve that one.                                                                                 |
| `SlackMessage.SlashCommandRequest_Create`                    | Given an HttpRequest and HttpResponse object validate and interpret the request. When successful the outcome is a `SlashCommandRequest` with all data you need to execute the slash command. |
| `SlackMessage.SlashCommandResponse_Create`                   | Create the response to the slash command. You have to provide the actual message to show and audience.                                                                                       |
| `SlackMessage.SlashCommandResponse_Create_VisibilityChannel` | This is a convenience function, see also `SlackMessage.SlashCommandResponse_Create`.                                                                                                         |
| `SlackMessage.SlashCommandResponse_Create_VisibilityUser`    | This is a convenience function, see also `SlackMessage.SlashCommandResponse_Create`.                                                                                                         |

### Rules

| Microflow                                             | Function                                                                         |
| ----------------------------------------------------- | -------------------------------------------------------------------------------- |
| `SlackMessage.Rule_SlashCommandRequest_IsSslCheck`    | Is this request an **SSL check**?                                                |
| `SlackMessage.Rule_SlashCommandRequest_IsNotSslCheck` | Is this request not an **SSL check**?                                            |
| `SlackMessage.Rule_SlashCommandRequest_IsValid`       | Is this request valid and can it be used to execute the requested slash command? |

### Snippets

| Microflow                  | Function           |
| -------------------------- | ------------------ |
| `SlackMessage.SN_SlackApp` | Manage Slack Apps. |

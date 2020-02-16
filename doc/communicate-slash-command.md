# Communicate using Slash Commands

- [Define Slash Commands in Slack](#define-slash-commands-in-slack)
- [Process Slash Commands by your app](#process-slash-commands-by-your-app)
- [Request authentication](#request-authentication)
- [Create the REST web service](#create-the-rest-web-service)

## Define Slash Commands in Slack

When you are going to use Slash Commands then you have to define them in the Slack app. In the example below command **/health** is defined.

![create slash commands](Slack&#32;screenshot&#32;6.png)

In this process you have to specify the **Request URL**. This is a URL that points to a REST web service in your app that processes the commands. This can be just a single web service because the command and other information are part of the request.

See [Slack documentation about Slash Commands](https://api.slack.com/interactivity/slash-commands) for more details.

## Process Slash Commands by your app

This SlackMessage module provides functionality that help you to process incoming Slash Commands. It does not provide full functionality to process your unique Slash Commands. See the sample project in [the GitHub repo](https://github.com/ppoetsma/SlackMessage) how to use the module's features.

## Request authentication

Incoming Slash Commands have to be authenticated before being processed. First you add your Slack app to your Mendix app manually via snippet `SN_SlackApp` or programmatically via microflows `SlackApp_Ensure` or `SlackApp_Upsert`.

The signing secret, which is used for authentication, is stored encrypted in the database. You find this signing secret in the configuration of the Slack app.

![signing secret](Slack&#32;screenshot&#32;5.png)

## Create the REST web service

You have to add a REST web service to your app which is capable of handling the incoming requests. Keep it simple, like in the example project.

Next, validate the request and process it. For validation you can use microflow `SlackMessage.SlashCommandRequest_Create` and if rule `SlackMessage.Rule_SlashCommandRequest_IsValid` says that it is ok, then you can do whatever needs to be done to process the command.

If, and this is optional, you would like to (temporarily) block all commands then add rule `SlackMessage.Rule_SlashCommandEnabled` to check the value of the corresponding constant. If TRUE then proceed, otherwise stop.

Just to mention it again, see the example project how to do it. The screenshot below shows the main flow:

![main flow web service handler](Handle&#32;slash&#32;commands.png)

# SlackMessage

This module has a single purpose: send messages to Slack channels.

## Features

Its features are

* uses Incoming Webhooks to send messages from your app to Slack
* process slash commands sent from Slack to your app
* sensitive data like Incoming Webhook URLs are stored encrypted
* create messages with markdown markup or just plain text
* send messages to multiple channels in multiple workspaces
* message can be sent in the background not delaying your primary process
* Dutch and English languages are supported in the UI

## Installation

Download the module from the AppStore and add it to your project.

Add microflow `ASu_SlackMessage` to your app's AfterStartup microflow.

The module depends on AppStore module [CommunityCommons](https://appstore.home.mendix.com/link/app/170/).

## Constants

The module adds these constants to your app and adjust them when needed.

* `SlackMessage.AutoCreateIncomingWebhook` - Automatically create the requested webhook, marked invalid, to be completed later. Every used webhook should be defined and marked valid. But when an unknown webhook is used then it is added to be completed manually.
* `SlackMessage.SendEnabled` - By default messages are sent on test, acceptance and production systems. In case you want to disable sending messages on a specific system then set this constant to FALSE in the environment's configuration.
* `SlackMessage.SendEnabledInDev` - By default messages are not sent on development systems. This prevents messages being sent while developing an app. However when you want messages to be sent, change this constant value to TRUE in your project's profile.
* `SlackMessage.SlackRequestTimeout` - Slack web service request timeout in seconds.
* `SlashCommandEnabled` - Ability to tell the app to process slash commands or not.

This constant is added and you have to change it because the default value is unusable:

* `SlackMessage.EncryptionKey` - The encryption key used to encrypt sensitive data like the Incoming Webhook URL which does not need authentication. Its length should exactly be 16 characters (128 bit). By default this key is not set so you have to create your own secure key. It is advised to use a combination of uppercase and lowercase characters, digits and special characters.

This constant is added but you should not change it:

* `SlackMessage.EncryptionPrefix` - A string that indicates if a string is encrypted or not. Changing it might prevent you to upgrade in the future.

## Security

The module offers these two roles:

* `Administrator` - manage Webhooks
* `User` - the minimum needed for regular users

## Send messages from your app to Slack

Instructions are in the [Send messages to Incoming Webhooks](doc/send-incoming-webhook.md) document.

## Use slash commands to communicate with your app

Instructions are in the [Communicate using slash commands](doc/communicate-slash-command.md) document.

## How to test this easily

[The GitHub repo](https://github.com/ppoetsma/SlackMessage) contains a Mendix model with features that can be used to test the module before adding it to your project. I use this myself to validate functionality, check security and to provide examples.

## Feedback

In case you have improvements leave them in [the GitHub repo](https://github.com/ppoetsma/SlackMessage/issues). Reviews can be put in the [Mendix AppStore](https://appstore.home.mendix.com/link/app/112818/).

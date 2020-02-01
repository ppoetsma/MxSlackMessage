# MxSlackMessage

This module has a single purpose: send messages to Slack channels.

## Features

Its features:

* uses Slack Webhooks
* send messages to multiple channels in multiple workspaces
* create messages with markdown markup, or just plain text
* specify message to be shown in the notification
* no Java, just a module

## Installation

Download the module from the AppStore and add it to your project.

## Security

The module offers these two roles:

* **Administrator** - manage Webhooks and test creating and sending messages
* **User** - just access to the Message (and related) entity to be able to create a message

## Create incoming Webhook(s)

First you have to create one or more Webhooks in Slack. You [can create an app that adds a Webhook](https://api.slack.com/messaging/webhooks) or [add the Incoming Webhook app](https://slack.com/apps/A0F7XDUAZ-incoming-webhooks) to your Slack workspace and configure it. You need a Webhook URL to use the module.

Add snippet **SN_Webhook** to a page to manage the Webhooks. Additionally you can use microflow **Webhook_Ensure** in (for example) the AfterStartup flow to add the Webhooks to the database. That *ensures* that the Webhook are there when the app started.

## Create message

You start by creating the basis of a message using microflow **Message_Initialize**. It requires a string that contains the text to be shown in the notification created by Slack. So this is not the message in the channel, but an OS notification telling that there is a message. [Markdown](https://api.slack.com/reference/surfaces/formatting) can be used in this message.

Next you add one or more lines to your message using microflow **Message_AddLine**. Also here [Markdown](https://api.slack.com/reference/surfaces/formatting) is supported.

An example of the text in such a line is below. The resulting message starts with `@here` which notifies all active users. Next it shows a large blue dot (emoji) and a text where the word **UP** is in **bold**.

```auto
<!here> :large_blue_circle: all systems are *UP*
```

## Send message

When you have created the message, send it using microflow **Message_Send**. It requires the key of the Webhook that you defined and the message object. On failure check the log file for details.

## Test creating and sending messages

Via snippet **SN_TestMessage** you can create messages and send them to Slack to test how it all works. Especially using emoji's and markdown might requires some testing to be sure that your messages are formatted as exepcted.

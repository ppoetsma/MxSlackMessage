# SlackMessage

This module has a single purpose: send messages to Slack channels.

## Features

Its features are

* uses Slack incoming Webhooks
* send messages to multiple channels in multiple workspaces
* create messages with markdown markup or just plain text
* specify message to be shown in the notification
* no Java, just native Mendix

## Installation

Download the module from the AppStore and add it to your project.

## Security

The module offers these two roles:

* **Administrator** - manage Webhooks
* **User** - the minimum needed for regular users

## Create incoming Webhook(s)

First you have to create one or more incoming Webhooks in Slack. You [can create an app](https://api.slack.com/messaging/webhooks) that adds the Webhook or add the [Incoming Webhook app](https://slack.com/apps/A0F7XDUAZ-incoming-webhooks) to your Slack workspace and configure it. Which method you prefer is up to you. In the end you need a Webhook URL to use the module. Such URL looks like `https://hooks.slack.com/services/somestring/anotherstring/alongerstring`.

A Webhook has these properties (all are required):

* **Label** - a descriptive human readable label
* **Key** - a sort unique key to be used in your microflows to find the right Webhook; only lowercase and uppercase characters, digits and underscores are allowed here
* **URL** - the incoming Webhook URL

Add snippet **SN_Webhook** to a page to manage your Webhooks. Additionally you can use microflow **Webhook_Ensure** in for example the AfterStartup flow to add the Webhooks to the database on app start.

## Create and send a single line message

Microflow **Message_CreateAndSend** can be used to send a single line message to Slack and can be used as an example how to use all steps separately with multi line messages.

The microflow has these parameters:

* **NotificationText** - the text to be shown in the OS notification, max 200 characters
* **NotificationTextType** - specify if the text markup is plain text or markdown
* **MessageText** - the text with the "real" message, max 3000 characters; when *empty* then it is skipped and the notification text is used
* **MessageTextType** - specify if the text markup is plain text or markdown
* **WebhookKey** - the key of the Webhook to send the message to

More details about, for example, text markup are in the paragraphs below.

## Create and send a multi-line message

You start a multi-line message by creating the basis of a message using microflow **Message_Initialize**. It requires a string that contains the text to be shown in the notification created by Slack. So this is not the message in the channel, but an OS notification telling that there is a message. [Markdown](https://api.slack.com/reference/surfaces/formatting) can be used in this message.

Next you add one or more lines to your message using microflow **Message_AddLine**. Also here [Markdown](https://api.slack.com/reference/surfaces/formatting) is supported.

An example of the text in such a line is below. The resulting message starts with `@here` which notifies all active users. Next it shows a large blue dot (emoji) and a text where the word **UP** is in **bold**.

```auto
<!here> :large_blue_circle: all systems are *UP*
```

An easy way to find the name of an emoji is to create a message in Slack manually and add the desired emoji. The popup where you search for your emoji shows the string to use.

When you have created the message you send it using microflow **Message_Send**. It requires the key of the Webhook that you created before.

On failure check the log file for details.

## Test creating and sending messages

The GitHub repo contains a Mendix model that can be used to test the module before adding it to your project.

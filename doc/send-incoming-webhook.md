# Send messages using Incoming Webhooks

- [Store webhooks in your app](#store-webhooks-in-your-app)
  - [Store in the module](#store-in-the-module)
  - [Store using your own method](#store-using-your-own-method)
- [Create and send a single line message](#create-and-send-a-single-line-message)
- [Create and send a multi-line message](#create-and-send-a-multi-line-message)

This page refers to **webhook** very often and read this as **Incoming Webhooks**. As **Outgoing Webhooks** also exist it is important to understand which one is referred to.

## Store webhooks in your app

The module offers two methods of storing and using webhook URLs:

1. create IncomingWebhook objects (provided by the module) where the URL is stored encrypted and in your microflows you refer to it using a unique key
2. store URLs using your own method and provide the clear text URL when sending messages

Which way is used to store the URLs in an app is not that important, pick what fits your app and requirements best. The convenience microflows described below support both.

### Store in the module

One way is to store URLs in entity `IncomingWebhook` provided by this module. It allows the developer to store URLs **encrypted** and use multiple webhooks in the app easily. The URLs are stored encrypted because they can be used without any means of authentication to send messages to the channel.

The entity has these attributes (all are required):

- `Label` - a descriptive human readable label
- `Key` - a sort unique key to be used in your microflows to find the right Webhook; only lowercase and uppercase characters, digits and underscores are allowed here
- `URL` - the webhook URL

It is highly recommended to store the values for `Key` in an enumeration. This makes using them more consistent and prevents error by typos.

Add snippet `SN_Webhook` to a page to manage your webhooks manually. Additionally you can use microflows `IncomingWebhook_Ensure` or `IncomingWebhook_Upsert` in for example the AfterStartup flow to add them to the database on app start automatically.

### Store using your own method

Another way is to store URLs using your own method and not use entity `IncomingWebhook` at all. For example the app uses just a single webhook and its URL is stored in a constant. If encrypting the URL is less important then there is no need to create an `IncomingWebhook` object. The module provides microflows that can send messages to Slack based on a clear text URL.

## Create and send a single line message

The microflows `Message_CreateAndSendToWebhookKey` and `Message_CreateAndSendToWebhookURL` can be used to send a single line message to Slack and can be used as an example how to use all steps separately with multi line messages.

The first microflow expects an `IncomingWebhook` object with the specified `key` to be in the database. The second microflow accepts an webhook URL as input.

The microflows have these parameters:

- `NotificationText` - the text to be shown in the OS notification, max 200 characters
- `NotificationTextType` - specify if the text markup is plain text or markdown
- `MessageText` - the text with the "real" message, max 3000 characters; when *empty* then it is skipped and the notification text is used
- `MessageTextType` - specify if the text markup is plain text or markdown
- `IncomingWebhookKey` or `IncomingWebhookURL` - the key or full URL of the webhook to send the message to
- `SendAsync` - use TRUE (preferred) to send the message in a separate background thread or FALSE to send it in the same thread

More details about text markup are in the paragraphs below.

On failure check the log file for details.

## Create and send a multi-line message

You start a multi-line message by creating the basis of a message using microflow `Message_Initialize`. It requires a string that contains the text to be shown in the notification created by Slack. So this is not the message in the channel, but an OS notification telling that there is a message. [Markdown](https://api.slack.com/reference/surfaces/formatting) can be used in this message.

Next you add one or more lines to your message using microflow `Message_AddLine`. Also here [Markdown](https://api.slack.com/reference/surfaces/formatting) is supported.

An example of the text in such a line is below. The resulting message starts with `@here` which notifies all active users. Next it shows a large blue dot (emoji) and a text where the word `UP` is in **bold**.

```auto
<!here> :green_heart: all systems are *UP*
```

An easy way to find the name of an emoji is to create a message in Slack manually, add the desired emoji and use the presented string. The popup where you search for your emoji shows the string to use.

When you have created the message then you send it using microflow `Message_SendToWebhookKey` or `Message_SendToWebhookURL`, depending which method to store webhook URLs you decided to use. They have these parameters:

- `Message` - the `Message` object you created
- `IncomingWebhookKey` or `IncomingWebhookURL` - the key or full URL of the webhook to send the message to
- `SendAsync` - use TRUE (preferred) to send the message in a separate background thread or FALSE to send it in the same thread

On failure check the log file for details.

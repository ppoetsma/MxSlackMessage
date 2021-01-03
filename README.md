# SlackMessage

This module has a two functions: send messages from your Mendix app to Slack channels and respond to commands sent from Slack to your app.

This allows your app to post messages in Slack channels, for example that it started or is going to shut down. And in the opposite direction you can use Slack to send commands to your app, for example to get a status update or to start a process.

## Features

Its features are

* Incoming Webhook URLs and other sensitive data are stored encrypted
* create messages with markdown markup or just plain text
* send messages to multiple channels in multiple workspaces
* message can be sent in the background not delaying your primary process
* no Java libraries that requires maintenance, just native Mendix
* Dutch and English languages are supported in the UI

## Installation

Download the module from the AppStore and add it to your project.

Add microflow `ASu_SlackMessage` to your app's AfterStartup microflow.

The module depends on AppStore module [CommunityCommons](https://appstore.home.mendix.com/link/app/170/).

## Security

The module offers these two roles:

* `Administrator` - manage Webhooks
* `User` - the minimum needed for regular users

## Send messages to Slack

Instructions are [available here](doc/send-to-slack.md).

## Receive commands from Slack

Instructions are [available here](doc/receive-from-slack.md).

## Test creating and sending messages

[The GitHub repo](https://github.com/ppoetsma/SlackMessage) contains a Mendix model with functions that can be used to test the module before adding it to your project. Snippet `SN_Webhook` has test functions too.

## Feedback

Please leave your feedback in [the GitHub repo](https://github.com/ppoetsma/SlackMessage/issues).

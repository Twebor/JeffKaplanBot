# Synopsis
The Man, the Myth, the Captain. You guessed it, it's Jeff Kaplan. Jeff Kaplan bot is the start of a personal Summer project that will be to create a personal Discord bot for a local friends server, and potentially more, if significant development comes through.

# Objectives
* To allow the bot to cycle every 5 minutes or so retrieving the latest post from a subreddit (/r/OverwatchMemes), and then post any updates to a given Discord channel.
* Expand the functionality to encompass other websites such as Twitter, DeviantArt, Tumblr.
* Adding monitoring functionality to track updates on other websites and post response neatly formatted.
* Create music playing functionality for the bot as other, current, bots sometimes may lack on efficient uptime.
* Deploy to a VPS for near 24/7 uptime. (Likely AWS)

# TODO
**Overwatch Meme Posting:**
- [x] Have bot able to send a message to a given channel.
- [ ] Retrieve and parse JSON response. (https://www.reddit.com/r/overwatchmemes/new.json?limit=1)
- [ ] Post formatted response to channel on command.
- [ ] Continue updating and posting on a given interval (while checking for duplicate posts).

# API Reference
https://github.com/austinv11/Discord4J (The main API used within the bot)

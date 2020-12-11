# User Crawler
## Introduction
This module crawls user data(avatar, username) from CSDN(a developer community in China) and store the data in local directory. This will be used as the initial mocking data for page rendering
## Techstack
- [Web Magic](https://github.com/code4craft/webmagic)
  
  Web Magic can cover the whole process of crawling including download the page, parse the page, manage the url and data persistence.
- Redis
  
  Here I also prepared a RedisScheduler which uses the redis to save the queue, so it can crawl the internet in a distributed system.

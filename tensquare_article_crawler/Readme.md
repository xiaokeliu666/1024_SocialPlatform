# Article Crawler
## Introduction
This module crawls article data(content and title) from CSDN(a developer community in China), store the data in local directory. 
If I'm crawling data from channel AI in CSDN, I will create a directory locally named AI as well, because these data will be used as training set for model.
In this module I set three categories: AI, db and web. More categories can be created if needed.
## Techstack
- [Web Magic](https://github.com/code4craft/webmagic)
  
  Web Magic can cover the whole process of crawling including download the page, parse the page, manage the url and data persistence.
- Redis
  
  Here I also prepared a RedisScheduler which uses the redis to save the queue, so it can crawl the internet in a distributed system.

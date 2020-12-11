# Article Classification
## Introduction
This module provides the service to do classfication against article based on the title and content. The training data of this module are acquired by [ArticleCrawler module](https://github.com/xiaokeliu666/1024_SocialPlatform/tree/xiaoke/tensquare_article_crawler) and there is another [UserCrawler module](https://github.com/xiaokeliu666/1024_SocialPlatform/tree/xiaoke/tensquare_user_crawler) in this project.
## Techstack
- Deeplearning4j
  Use Word2Vec to turn text into a numerical form that deep nets can understand.
- IK Analyzer
  This analyzer define the way to interpret the sentence in Chinese by setting granularity which will result in different 

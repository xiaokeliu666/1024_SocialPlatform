# Article Classification
## Introduction
This module provides the service to do classfication against article based on the title and content. The training data of this module are acquired by [ArticleCrawler module](https://github.com/xiaokeliu666/1024_SocialPlatform/tree/xiaoke/tensquare_article_crawler) and there is another [UserCrawler module](https://github.com/xiaokeliu666/1024_SocialPlatform/tree/xiaoke/tensquare_user_crawler) in this project.
## Techstack
- Deeplearning4j
  
  Use Word2Vec to turn text into a numerical form that deep nets can understand.
- IK Analyzer
  
  This analyzer define the way to interpret the sentence in Chinese by setting granularity which will result in different 
## How to use
As user enter the text content as input, this service will generate a set of values to indicate the relevance between this text and the certain classification and higher value means more relevant, for example:
```
  web: 0.8736182
  db: 0.8273561
  ai: 0.2319821
```
Since I only created three categories here, the result may vary in the future as more categories created. However, in my opinion, my expectation about this module is to provide multiple options to the user after the article is done to attach tags to their articles instead of simply classify the article to a certain category, because a technical article usually involves different areas.

## How to improve
When I programmed and tested this module, I only crawled hundreds of article as my training set which is obviously not enough. So, the model can be improved with bigger training set:
1. Run the crawler for longer time to download more articles.
2. Keep the crawler service on and set schedule to run periodically which I already done in [ArticleCrawler module](https://github.com/xiaokeliu666/1024_SocialPlatform/tree/xiaoke/tensquare_article_crawler).

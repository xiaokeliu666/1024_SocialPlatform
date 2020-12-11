package com.tensquare.articlecrawler.pipeline;

import com.tensquare.articlecrawler.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import util.HTMLUtil;
import util.IKUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Component
public class ArticleTextPipeline implements Pipeline {
    @Value("${ai.dataPath}")
    private String dataPath;

    private String channelId;
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        String title = resultItems.get("title");
        String content = HTMLUtil.delHTMLTag(resultItems.get("content"));
        try {
            String result = IKUtil.split(title + content, " ");
            PrintWriter printWriter = new PrintWriter(new File(dataPath +"/"+ channelId+"/"+UUID.randomUUID()+".txt"));
            printWriter.print(result);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

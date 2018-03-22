package com.api.publish_article.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.api.publish_article.PublishArticleApplication;
import com.api.publish_article.domain.Article;


/**
 * @author rkarim
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PublishArticleApplication.class)
@WebAppConfiguration
public class ArticleControllerTest {
  
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));
  
  private MockMvc mockMvc;
  
  private HttpMessageConverter mappingJackson2HttpMessageConverter;
  
  @Autowired
  private WebApplicationContext webApplicationContext;

  
  @Before
  public void setup() throws Exception {
      this.mockMvc = webAppContextSetup(webApplicationContext).build();

  }
  
  @Autowired
  void setConverters(HttpMessageConverter<?>[] converters) {

      this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
          .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
          .findAny()
          .orElse(null);

      assertNotNull("the JSON message converter must not be null",
              this.mappingJackson2HttpMessageConverter);
  }
  
  @Test
  public void createTest() throws IOException, Exception{
    LocalDateTime publishDate = LocalDateTime.now();
    mockMvc.perform(post("/api/v1/article/create")
        .content(this.json(new Article("test header", "Test desc", "Test text",
            publishDate,"Test author", "kewwords")))
        .contentType(contentType))
        .andExpect(status().isOk());
  }
  
  @Test
  public void updateTest() throws IOException, Exception{
    LocalDateTime publishDate = LocalDateTime.now();
    mockMvc.perform(post("/api/v1/article/1/update")
        .content(this.json(new Article("test header11", "Test desc11", "Test text11",
            publishDate,"Test author11", "kewwords")))
        .contentType(contentType))
        .andExpect(status().isOk());
  }
  
  @Test
  public void deleteTest() throws IOException, Exception{
    mockMvc.perform(delete("/api/v1/article/2/delete")
        .contentType(contentType))
        .andExpect(status().isOk());
  }
  
  @Test
  public void findByAuthorTest() throws IOException, Exception{
    mockMvc.perform(get("/api/v1/article/author?name=test")
        .contentType(contentType))
        .andExpect(status().isOk());
  }
  
  @Test
  public void findOneTest() throws IOException, Exception{
    mockMvc.perform(get("/api/v1/article/findone/1")
        .contentType(contentType))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.header", is("test")))
        .andExpect(jsonPath("$.id", is(1)));
  }
  
  @Test
  public void findBetweenDatesTest() throws IOException, Exception{
    mockMvc.perform(get("/api/v1/article/findbetween?start=2018-04-04 00:00&end=2018-04-12 00:00")
        .contentType(contentType))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].header", is("test")))
        .andExpect(jsonPath("$.[0].id", is(1)));
  }
  
  
  protected String json(Object o) throws IOException {
    MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
    this.mappingJackson2HttpMessageConverter.write(
            o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
    return mockHttpOutputMessage.getBodyAsString();
  }

}

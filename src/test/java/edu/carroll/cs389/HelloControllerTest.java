package edu.carroll.cs389;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexTest() throws Exception {
        mockMvc.perform(get("/?name=random")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("<!DOCTYPE HTML>\n<html>\n<head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n    <title>Serving HTML Content</title>\n</head>\n<body>\n<p>Hello, random!</p>\n</body>\n</html>")));
    }
}
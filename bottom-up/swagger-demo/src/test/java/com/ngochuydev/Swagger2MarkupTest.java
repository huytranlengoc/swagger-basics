package com.ngochuydev;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.github.robwin.markup.builder.MarkupLanguage;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

/*@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootRestApiApp.class)*/
public class Swagger2MarkupTest {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation)).build();
	}

	@Test
	public void convertSwaggerToAsciiDoc() throws Exception {
		this.mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/asciidoc/generated").build())
				.andExpect(status().isOk());
	}

	@Test
	public void convertSwaggerToMarkdown() throws Exception {
		this.mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON)).andDo(Swagger2MarkupResultHandler
				.outputDirectory("src/docs/markdown/generated").withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
				.andExpect(status().isOk());
	}

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

}

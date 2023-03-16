package com.sezo.demo;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sezo.demo.controller.UserController;

@WebMvcTest(UserController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/user/test"))
		        .andDo(print()).andExpect(status().isOk())
	            .andExpect(jsonPath("$.message").value("Hi There"))
				.andDo(document("all"));
	}
	
	@Test
	public void shouldReturnUSer() throws Exception {
		this.mockMvc.perform(get("/user/greeting/{id}",1L))
		       .andDo(print())
		       .andExpect(status().isOk())
	           .andExpect(jsonPath("$.id").value(1L))
	           .andExpect(jsonPath("$.name").value("Sezayir"))
	           .andExpect(jsonPath("$.surname").value("Dagtekin"))
			   .andDo(document("byid"));
	}
	
	@Test
	public void shouldReturnUSerList() throws Exception {
			this.mockMvc.perform(get("/user/all"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.size()").value(2))
			.andDo(document("userlist"));
	}
	
	@Test
	public void createUserAPI() throws Exception 
	{
		String user = """
				{
						"id": 3,
						"name": "John",
						"surname": "Papa"
					}""";
		
		mockMvc.perform( MockMvcRequestBuilders	
			.post("/user/save")
            .content(user)
            .contentType(MediaType.APPLICATION_JSON)
		    .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isCreated())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
	    	.andDo(document("saveuser"));;
	}

	
}

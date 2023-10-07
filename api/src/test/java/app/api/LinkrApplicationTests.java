package app.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.transaction.annotation.Transactional;

import lombok.val;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.json.JSONException;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@AutoConfigureMockMvc
class LinkrApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void createValidUser() throws Exception {
		JSONObject validBody = new JSONObject();
		validBody.put("email", "joao@gmail.com");
		validBody.put("password", "123456789");
		validBody.put("name", "joao");
		validBody.put("picUrl", "https://urlscurta.com/rCXms");

		mockMvc.perform(post("/auth/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(validBody.toString())).andExpect(status().isCreated());
	}

	@Test
	void loginWithValidUser() throws Exception {
		JSONObject user = new JSONObject();
		user.put("email", "joao@gmail.com");
		user.put("password", "123456789");
		user.put("name", "joao");
		user.put("picUrl", "https://urlscurta.com/rCXms");

		mockMvc.perform(post("/auth/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(user.toString()));

		JSONObject validBody = new JSONObject();
		validBody.put("email", "joao@gmail.com");
		validBody.put("password", "123456789");

		mockMvc.perform(post("/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(validBody.toString())).andExpect(status().isOk());
	}

}

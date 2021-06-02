package br.com.shortcoffee;

import br.com.shortcoffee.entity.Cafeicultor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class CafeAplicacaoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void criandoCafeicultor1() throws Exception { // Success
        Cafeicultor cafeicultor = Cafeicultor.builder().cpf("123456").email("moises@gmail.com").nome("Moises").telefone("4002-8922").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cafeicultor);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/coffee/cafeicultor")
                .content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void criandoCafeicultor2() throws Exception { // Fail
        Cafeicultor cafeicultor = Cafeicultor.builder().cpf("123456").email("moises@gmail.com").nome("Moises").telefone("4002-8922").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cafeicultor);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/coffee/cafeicultor")
                .content(json).contentType(MediaType.APPLICATION_JSON)  
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertEquals("Cpf já cadastrado", result.getResolvedException().getMessage()));
    }

    @Test
    public void criandoCafeicultor3() throws Exception { // Email faill
        Cafeicultor cafeicultor = Cafeicultor.builder().cpf("456789").email("moisesgmail.com").nome("Moises").telefone("4002-8922").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cafeicultor);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/coffee/cafeicultor")
                .content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}

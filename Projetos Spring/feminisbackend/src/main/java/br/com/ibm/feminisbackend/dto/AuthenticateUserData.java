package br.com.ibm.feminisbackend.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserData {
    private Long id;
    private String username;
    private String password;

    /**
     * @param authenticateUserData
     * @return
     */
    public String toJson(AuthenticateUserData authenticateUserData) {
        ObjectWriter toJson = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return toJson.writeValueAsString(authenticateUserData);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}

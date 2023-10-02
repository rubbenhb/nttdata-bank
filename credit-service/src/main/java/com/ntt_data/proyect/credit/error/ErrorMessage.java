package com.ntt_data.proyect.credit.error;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.validation.BindingResult;
import java.util.*;
import java.util.stream.Collectors;
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class ErrorMessage {
    private String code;
    private List<Map<String,String>> message;
    public ErrorMessage(String code, String field, String defaultMessage) {
        this.code = code;
        Map<String, String> error = new HashMap<>();
        error.put(field, defaultMessage);
        this.message = Collections.singletonList(error);
    }

    public static String formatMessage(BindingResult result){
        List <Map<String,String>> errors = result.getFieldErrors().stream().map(
                err->{
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder().code("01").message(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.getMessage();
        }
        return jsonString;
    }
}

package com.example.demo.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorObject {

    private int statusCode;
    private String msg;

//        @Autowired
//        private ObjectMapper objectMapper;
//
//        public Optional<String> objToJson(MyObj obj) {
//
//            try {
//                String objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
//            } catch (JsonProcessingException e) {
//                log.debug("failed conversion: Pfra object to Json", e);
//            }
//        });

}

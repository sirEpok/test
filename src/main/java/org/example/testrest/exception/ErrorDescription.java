package org.example.testrest.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDescription {
    @JsonProperty("head")
    private String head;
    @JsonProperty("text")
    private String text;
}

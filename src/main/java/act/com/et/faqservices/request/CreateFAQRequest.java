package act.com.et.faqservices.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateFAQRequest {

    @NotBlank(message="Question is required.")
    private String question;

    @NotBlank(message = "Answer is required.")
    private String answer;

    @JsonProperty("created_by")
    @NotBlank(message = "Created by is required.")
     private String createdBy;

    private String updatedBy;

    //@NotEmpty(message = "Created date must not be null.")
    @NotNull(message = "Created date must not be null.")
    private LocalDate createdDate;

    private LocalDate updateDate;
}

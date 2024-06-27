package act.com.et.faqservices.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateFAQRequest {

    @NotNull(message = "FAQ Id is required.")
    private Long id;

    private String question;

    private String answer;

    @JsonProperty("created_by")
    private String createdBy;

    private String updatedBy;

    private LocalDate createdDate;

    private LocalDate updateDate;
}

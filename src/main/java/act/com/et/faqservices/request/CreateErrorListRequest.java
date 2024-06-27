package act.com.et.faqservices.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateErrorListRequest {

    @NotBlank(message = "error type is required.")
    private String errorType;

    @NotBlank(message = "error code is required.")
    private String errorCode;

    @NotBlank(message = "message is required.")
    private String message;

    @NotBlank(message = "reason is required.")
    private String reason;

    @NotBlank(message = "resolution is required.")
    private String resolution;

}

package act.com.et.faqservices.response;

import act.com.et.faqservices.domain.ErrorList;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorListResponse {

    private Long id;

    @JsonProperty("error_type")
    private String errorType;

    private String errorCode;

    private String message;

    private String reason;

    private String resolution;

    public  ErrorListResponse(ErrorList errorList){
        this.id=errorList.getId();
        this.errorType=errorList.getErrorType();
        this.errorCode=errorList.getErrorCode();
        this.message=errorList.getMessage();
        this.reason=errorList.getReason();
        this.resolution=errorList.getResolution();
    }
}

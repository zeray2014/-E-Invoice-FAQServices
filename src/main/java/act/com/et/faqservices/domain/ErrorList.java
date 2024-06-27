package act.com.et.faqservices.domain;

import act.com.et.faqservices.request.CreateErrorListRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="errorList")
public class ErrorList {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="error_type")
    private String errorType;

    @Column(name="error_code")
    private String errorCode;

    @Column(name="message")
    private String message;

    @Column(name="reason")
    private String reason;

    @Column(name="resolution")
    private String resolution;

public ErrorList(CreateErrorListRequest errorListRequest){
    this.errorType=errorListRequest.getErrorType();
    this.errorCode=errorListRequest.getErrorCode();
    this.message=errorListRequest.getMessage();
    this.reason=errorListRequest.getReason();
    this.resolution=errorListRequest.getResolution();
   }

}

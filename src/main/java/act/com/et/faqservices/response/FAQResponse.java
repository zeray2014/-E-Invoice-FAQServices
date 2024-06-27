package act.com.et.faqservices.response;

import act.com.et.faqservices.domain.FAQ;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FAQResponse {

    private Long id;

    private String question;

    private String answer;

    @JsonProperty("created_by")
    private String createdBy;

    private String updatedBy;

    private LocalDate createdDate;

    private LocalDate updateDate;

    public FAQResponse(FAQ faq){

        this.id=faq.getId();
        this.question=faq.getQuestion();
        this.answer=faq.getAnswer();
        this.createdBy=faq.getCreatedBy();
        this.updatedBy=faq.getUpdatedBy();
        this.createdDate=faq.getCreatedDate();
        this.updateDate=faq.getUpdateDate();
    }
}

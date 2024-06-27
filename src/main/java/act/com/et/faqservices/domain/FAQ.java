package act.com.et.faqservices.domain;

import act.com.et.faqservices.request.CreateFAQRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="faq")
public class FAQ {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="question")
    private String question;

    @Column(name="answer")
    private String answer;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="update_date")
    private LocalDate updateDate;

    public FAQ(CreateFAQRequest createFAQRequest){
        this.question=createFAQRequest.getQuestion();
        this.answer=createFAQRequest.getAnswer();
        this.createdBy=createFAQRequest.getCreatedBy();
        this.updatedBy=createFAQRequest.getUpdatedBy();
        this.createdDate=createFAQRequest.getCreatedDate();
        this.updateDate=createFAQRequest.getUpdateDate();
    }


}

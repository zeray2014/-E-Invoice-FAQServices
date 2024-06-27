package act.com.et.faqservices.service;

import act.com.et.faqservices.repository.FAQRepository;
import act.com.et.faqservices.request.CreateFAQRequest;
import act.com.et.faqservices.request.UpdateFAQRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import act.com.et.faqservices.domain.FAQ;

import java.util.List;
import java.util.Optional;

@Service
public class FAQService {

    @Autowired
    private FAQRepository faqRepository;

    /*public FAQ  createFAQ(FAQ faq){
           FAQ createdFAQ = faqRepository.save(faq);
        return createdFAQ;
    }*/

    public FAQ  createFAQ(CreateFAQRequest createFAQRequest){
        FAQ faq =  new FAQ(createFAQRequest);

        faq = faqRepository.save(faq);

        return  faq;


    }

    public  FAQ updateFAQ(UpdateFAQRequest updateFAQRequest){
        FAQ faq = faqRepository.findById(updateFAQRequest.getId()).get();

        if(updateFAQRequest.getQuestion() != null &&
        !updateFAQRequest.getQuestion().isEmpty()){
            faq.setQuestion(updateFAQRequest.getQuestion());
        }
        //TO DO
        //Add other fields like above

        faq = faqRepository.save(faq);

        return faq;
    }

    public List<FAQ> getAllFAQs(){
        return faqRepository.findAll();
    }

    public Optional<FAQ> getFAQById(Long id){
        return faqRepository.findById(id);
    }

    public FAQ updatedFAQ(Long id, FAQ faq){
        Optional<FAQ>existingFAQ = faqRepository.findById(id);
        if(existingFAQ.isPresent()){
            FAQ updatedFAQ = existingFAQ.get();
            updatedFAQ.setQuestion(faq.getQuestion());
            updatedFAQ.setAnswer(faq.getAnswer());
            updatedFAQ.setCreatedBy(faq.getCreatedBy());
            updatedFAQ.setUpdatedBy(faq.getUpdatedBy());
            updatedFAQ.setCreatedDate(faq.getCreatedDate());
            updatedFAQ.setUpdateDate(faq.getUpdateDate());

            return faqRepository.save(updatedFAQ);
        } else{
            throw new RuntimeException("FAQ not found with id "+id);
        }
    }

    public void deleteFAQ(Long id){
        faqRepository.deleteById(id);
    }

}

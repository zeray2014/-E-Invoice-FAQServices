package act.com.et.faqservices.controller;

import act.com.et.faqservices.request.CreateFAQRequest;
import act.com.et.faqservices.request.UpdateFAQRequest;
import act.com.et.faqservices.response.FAQResponse;
import act.com.et.faqservices.service.FAQService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import act.com.et.faqservices.domain.FAQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/FAQServices")
public class FAQController {

    @Autowired
    private FAQService faqService;


    /*@PostMapping("/create")
    public ResponseEntity<FAQ> createFAQ(@RequestBody FAQ faq){
        FAQ createdFAQ  = faqService.createFAQ(faq);

        return ResponseEntity.ok(createdFAQ);

    }*/

    @PostMapping("/create")
    public FAQResponse createFAQ( @Valid @RequestBody CreateFAQRequest createFAQRequest){
        FAQ faq  = faqService.createFAQ(createFAQRequest);

        return  new FAQResponse(faq);
    }

    /*@GetMapping("/getAllFAQ")
    public List<FAQ> getAllFAQs(){
        return faqService.getAllFAQs();
    }*/
    @GetMapping("/getAllFAQ")
    public List<FAQResponse> getAllFAQs(){
        List<FAQ> faqList = faqService.getAllFAQs();

        List<FAQResponse> faqResponseList = new ArrayList<FAQResponse>();

        faqList.stream().forEach(faq -> {
            faqResponseList.add(new FAQResponse(faq));
        });

        return faqResponseList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FAQ> getFAQById(@PathVariable Long id){
        Optional<FAQ> faq = faqService.getFAQById(id);
        return faq.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    /*@PutMapping("/{id}")
    public ResponseEntity<FAQ> updateFAQ(@PathVariable Long id, @RequestBody FAQ faq){
        try{
            FAQ updatedFAQ = faqService.updatedFAQ(id, faq);
            return ResponseEntity.ok(updatedFAQ);

        }catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }*/

    @PutMapping("update")
    public FAQResponse updateFAQ(@Valid @RequestBody UpdateFAQRequest updateFAQRequest){

        FAQ faq  = faqService.updateFAQ(updateFAQRequest);

        return  new FAQResponse(faq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFAQ(@PathVariable Long id){
        faqService.deleteFAQ(id);

        return ResponseEntity.noContent().build();
    }

    /*@DeleteMapping("{id}")
    public ResponseEntity<String> deleteFAQ(@PathVariable Long id){
        faqService.deleteFAQ(id);

        return ResponseEntity.ok("FAQ Successfully deleted");
    }*/
}

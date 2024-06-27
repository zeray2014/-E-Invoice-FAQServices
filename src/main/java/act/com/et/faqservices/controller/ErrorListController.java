package act.com.et.faqservices.controller;

import act.com.et.faqservices.domain.ErrorList;
import act.com.et.faqservices.domain.FAQ;
import act.com.et.faqservices.request.CreateErrorListRequest;
import act.com.et.faqservices.response.ErrorListResponse;
import act.com.et.faqservices.service.ErrorListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ErrorList")
public class ErrorListController {

    @Autowired
    private ErrorListService errorListService;

/*@PostMapping("/create")
    public ResponseEntity<ErrorList> createErrorList(@RequestBody ErrorList errorList){
        ErrorList errorListCreated = errorListService.createErrorList(errorList);

        return ResponseEntity.ok(errorListCreated);
    }*/

    @PostMapping("/create")
    public ErrorListResponse createErrorList(@Valid @RequestBody CreateErrorListRequest createErrorListRequest){
        ErrorList errorList = errorListService.createErrorList(createErrorListRequest);

        return new ErrorListResponse(errorList);
    }

@GetMapping("/getAllerrorList")
public List<ErrorList> getAllErrorList(){
    return  errorListService.getAllErrorLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErrorList> getErrorListById(@PathVariable Long id){
        Optional<ErrorList> errorList = errorListService.getErrorListById(id);

        return errorList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorList> updateErrorList(@PathVariable Long id, @RequestBody ErrorList errorList){
        try{
            ErrorList updatederrorList = errorListService.updatedErrorList(id, errorList);
            return ResponseEntity.ok(updatederrorList);

        }catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteErrorList(@PathVariable Long id){
        errorListService.deleteErrorlist(id);

        return ResponseEntity.noContent().build();
    }

    /*@DeleteMapping("{id}")
    public ResponseEntity<String> deleteErrorList(@PathVariable Long id){
        errorListService.deleteErrorlist(id);

        return ResponseEntity.ok("ErrorList successfully deleted"));
    }*/
}

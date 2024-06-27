package act.com.et.faqservices.service;

import act.com.et.faqservices.domain.FAQ;
import act.com.et.faqservices.repository.ErrorListRepository;
import act.com.et.faqservices.request.CreateErrorListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import act.com.et.faqservices.domain.ErrorList;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorListService {

    @Autowired
    private ErrorListRepository errorListRepository;

    /*public ErrorList createErrorList(ErrorList errorList){
        ErrorList errorListCreated = errorListRepository.save(errorList);

        return errorListCreated;
    }*/
    public ErrorList createErrorList(CreateErrorListRequest createErrorListRequest){
        ErrorList errorList = new ErrorList(createErrorListRequest);

        errorList =   errorListRepository.save(errorList);

        return errorList;
    }

    public List<ErrorList> getAllErrorLists(){
        return errorListRepository.findAll();
    }

    public Optional<ErrorList> getErrorListById(Long id){
        return errorListRepository.findById(id);
    }

    public ErrorList updatedErrorList(Long id, ErrorList errorList){
        Optional<ErrorList>existingErrorList = errorListRepository.findById(id);

        if(existingErrorList.isPresent()){
            ErrorList updatedErrorList = existingErrorList.get();
            updatedErrorList.setErrorType(errorList.getErrorType());
            updatedErrorList.setErrorCode(errorList.getErrorCode());
            updatedErrorList.setMessage(errorList.getMessage());
            updatedErrorList.setReason(errorList.getReason());
            updatedErrorList.setResolution(errorList.getResolution());


            return errorListRepository.save(updatedErrorList);

        } else{
            throw new RuntimeException("ErrorList not found with id "+id);
        }
    }

    public void deleteErrorlist(Long id){
        errorListRepository.deleteById(id);
    }

}

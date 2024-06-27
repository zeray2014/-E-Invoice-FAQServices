package act.com.et.faqservices.repository;

import act.com.et.faqservices.domain.ErrorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorListRepository extends JpaRepository<ErrorList, Long> {
}

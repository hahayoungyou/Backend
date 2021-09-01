package monthsago.tarvel16.Service;

import monthsago.tarvel16.Model.Test;
import monthsago.tarvel16.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> getTest() {
        return testRepository.findAll();

    }
}

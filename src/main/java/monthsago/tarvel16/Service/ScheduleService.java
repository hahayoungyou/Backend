package monthsago.tarvel16.Service;

import monthsago.tarvel16.Model.Board;
import monthsago.tarvel16.Model.Schedule;
import monthsago.tarvel16.Repository.ScheduleRepository;
import monthsago.tarvel16.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);

    }
    public List<Schedule> getSchedule(String no) {
        return scheduleRepository.getSchedulelist(no);

    }
    public void deleteSchedule(Integer no) {
         scheduleRepository.deleteById(no);

    }

    public void updateSchedule(Integer no,Schedule schedule) {
        Schedule sch = scheduleRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));
        sch.setTitle(schedule.getTitle());
        sch.setStartdate(schedule.getStartdate());
        sch.setEnddate(schedule.getEnddate());
        scheduleRepository.save(sch);

    }
}

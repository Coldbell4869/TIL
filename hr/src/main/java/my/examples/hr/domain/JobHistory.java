package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_history¡")
@Setter
@Getter
public class JobHistory {
    @EmbeddedId
    private JobHistoryId jobHistoryId;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public JobHistory(){
        endDate = new Date();
    }



}

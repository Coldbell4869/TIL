package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jobs")
@Setter
@Getter
public class Job {
    @Id
    private String jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;

    @OneToMany(mappedBy="job")
    private Set<Employee> employees;
    @OneToMany
    private Set<JobHistory> jobHistories;

    public Job(){
        employees = new HashSet<>();
        jobHistories = new HashSet<>();
    }


}

package com.jobfinder.springboot.assignmentdemo.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
@Table(name="jobs")
public class Job {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="company_name")
    private String companyName;






    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Job(String title, String companyName) {
        this.title = title;
        this.companyName = companyName;
    }

    //@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    //@JsonIgnore
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    //@JsonIgnore
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Job() {

    }

    public Job(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public List<Skill> getSkills() {
        return skills;
    }





    public void addSkill(Skill theSkill) {

        if (skills == null) {
            skills = new ArrayList<>();
        }

        skills.add(theSkill);
    }
    public void addLocation(Location theLocation) {

        if (theLocation == null) {
            locations = new ArrayList<>();
        }

        locations.add(theLocation);
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}




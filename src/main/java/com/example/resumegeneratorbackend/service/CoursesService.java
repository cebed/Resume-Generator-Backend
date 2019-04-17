package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.Courses;
import com.example.resumegeneratorbackend.model.Workexperience;
import com.example.resumegeneratorbackend.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;





    public List<Courses> getAll() {

        return coursesRepository.findAll();
    }


    public Courses Register(Courses courses) {

        return  coursesRepository.save(courses);
    }




    public Courses updateCourse( Courses u, int id) {
        return coursesRepository.findById(id)
                .map(Courses -> {
                    Courses.setTitle(u.getTitle());
                  //  Courses.setDescription(u.getDescription());
                   // Courses.getStart_date(u.getEnd_date());
                   Courses.setStart_date(u.getStart_date());
                    return coursesRepository.save(u);
                })
                .orElseGet(() -> {
                    u.setCoursesId(id);
                    return coursesRepository.save(u);
                });

    }



    public Courses coursesById(int id){
        Courses courses = new Courses();
       for(Courses course : getAll()){
            if(course.getCoursesId()==id){
                courses = course;
            }
       }
       if(!courses.getCoursesId().equals(null)){

           return courses;

       }
       else return null;
    }


    public String deleteWorExpeience(Integer id) {


        coursesRepository.deleteById(id);
        return "kaos";

    }



}

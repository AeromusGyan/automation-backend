package com.automation.automation.repo;

import com.automation.automation.model.Courses;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CoursesRepository extends CrudRepository<Courses, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET registration_link = :r, offering_id = :o where c_id = :id", nativeQuery = true)
    public void updateCourse(@Param("id") Long cId,
                             @Param("o") Long offeringId,
                             @Param("r") String registration_link);

    @Query(value = "SELECT * FROM courses WHERE start_date >= :start AND end_date <= :end", nativeQuery = true)
    public List<Courses> getDataStartEnd(@Param("start") String start,
                                         @Param("end") String end);

    @Query(value = "SELECT * FROM courses WHERE course_type = :type OR course_mode LIKE :mode% OR month LIKE :month% OR course_name LIKE :cname", nativeQuery = true)
    public List<Courses> getDataByType(@Param("type") String type,
                                       @Param("mode") String mode,
                                       @Param("month") String month,
                                       @Param("cname") String cname);


}

package com.vn.devmaster.services.repository;

import com.vn.devmaster.services.Untils.Sql;
import com.vn.devmaster.services.domain.Student;
import com.vn.devmaster.services.dto.AddressDto;
import com.vn.devmaster.services.projection.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // viết query theo native
//    @Query(nativeQuery = true, value = "select * from student " +
//            "where first_name = :name")
//     List<Student> getByName(@Param("name") String Name);

    // HQL
    @Query(value = "select s from Student s where  s.firstName like concat('%',:name,'%')")
    List<Student> getByName(@Param("name") String name);

//    c3
//    List<Student> findAllByFirstName(String name);;
    @Query(value = "select a from Address a where  a.id = :id")
    List<AddressDto> GetById(@Param("id") Integer id);


    @Query(value = "select s from Student s where s.address.city like concat('%',:city,'%') ")
    List<Student> findAllByAddress_City(@Param("city") String city);

    @Query(nativeQuery = true, value = "select s.* from student s\n" +
            "                inner join student_subject ss on s.id = ss.id_student\n" +
            "                inner join subject s2 on ss.id_subject = s2.id\n" +
            "            where s2.name like concat('%', :name , '%')")
    List<Student> findAllBySubjects(@Param("name") String name);

    @Query(nativeQuery = true,value = "select s.* from student s\n" +
            "                inner join student_subject ss on s.id = ss.id_student\n" +
            "                inner join subject s2 on ss.id_subject = s2.id\n" +
            "            where ss.point > 8")
    List<Student> findAllByPoint();

    @Query(nativeQuery = true,value = "select s.* from student s\n" +
            "    inner join student_classes sc on s.id = sc.id_student\n" +
            "    inner join classes c on sc.id_class = c.id\n" +
            "where sc.id_class = 01\n")
    List<Student> findAllByClass();

    @Query(nativeQuery = true,value = Sql.STUDENT_FILTER_CLASS)
    List<IStudentFIlterclass> findAllByAClass_Name(@Param("className") String className);

    @Query(nativeQuery = true, value = Sql.STUDENT_FILTER_AVG)
    List<IStudentFilerAVG> findAllByClass_AVG(@Param("className") String className);

    @Query(nativeQuery = true,value = Sql.STUDENT_FILTER_AVG8)
    List<IStudentFilterAVG8> findAllByClass_AVG8(@Param("className") String className);

    @Query(nativeQuery = true,value = Sql.STUDENT_POINT_AVG)
    List<IStudentPointAVG> findStudentBy_AVG(@Param("nameSubject") String nameSubject);

    @Query(nativeQuery = true,value = Sql.STUDENT_POINT_MAX)
    List<IStudentFilerMaxPoint> findStudentBy_PointMax(@Param("studentName") String studentName);

    @Query(nativeQuery = true, value = Sql.STUDENT_HOCBONG_MAX)
    List<IStudentFilerMaxHocBong> findStudentBy_HocBongMax();

}
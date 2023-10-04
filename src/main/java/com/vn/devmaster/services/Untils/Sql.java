package com.vn.devmaster.services.Untils;

public class Sql {
    public static final String STUDENT_FILTER_CLASS = "" +
            "select s.id as id,\n " +
            "concat(s.last_name, ' ', s.first_name) as name,\n" +
            "c.name as className,\n " +
            "sub.name as subjcetName,\n " +
            "ss.point as point\n" +
            " from student s\n" +
            "    left join classes c on s.id_class = c.id\n"+
            "    left join student_subject ss on s.id = ss.id_student\n" +
            "    left join subject sub on ss.id_subject = sub.id\n" +
            "where c.name = :className";

    public static final String STUDENT_FILTER_AVG = "" +
            "select s.id as id,\n" +
            "    concat(s.last_name, ' ', s.first_name) as name,\n" +
            "    c.name as className,\n" +
            "    sub.name as subjcetName,\n" +
            "    avg(ss.point) as averageofsubject\n" +
            "from student s\n" +
            "    left join classes c on s.id = c.id_classes\n" +
            "    left join student_subject ss on s.id = ss.id_student\n" +
            "    left join subject sub on ss.id_subject = sub.id\n" +
            "where c.name = :className\n" +
            "group by s.id,\n" +
            "    concat(s.last_name, ' ', s.first_name),\n" +
            "    c.name,\n" +
            "    sub.name";

    public static final String STUDENT_FILTER_AVG8 = "" +
            "select s.id as id,\n" +
            "        concat(s.last_name, ' ', s.first_name) as name,\n" +
            "        c.name as className,\n" +
            "        sub.name as subjcetName,\n" +
            "        avg(ss.point) as point\n" +
            "from student s\n" +
            "        left join classes c on s.id = c.id_classes\n" +
            "        left join student_subject ss on s.id = ss.id_student\n" +
            "        left join subject sub on ss.id_subject = sub.id\n" +
            "where c.name = :className and point > 8\n" +
            "group by s.id,\n" +
            "        concat(s.last_name, ' ', s.first_name),\n" +
            "        c.name,\n" +
            "        sub.name\n" +
            "order by s.id ASC";

    public static final String STUDENT_POINT_AVG = "" +
            "select " +
            "sub.id as IDSubject,\n" +
            "sub.name as nameSubject,\n" +
            "avg(ss.point) as point\n" +
            "from student s\n" +
            "        left join student_subject ss on s.id = ss.id_student\n" +
            "        left join subject sub on ss.id_subject = sub.id\n" +
            "where sub.name = :nameSubject\n" +
            "group by sub.id, sub.name";
    public static final String STUDENT_POINT_MAX = "" +
            "select concat(s.last_name, ' ', s.first_name) as name,\n" +
            "max(ss.point) as point\n" +
            "from student s\n" +
            "        left join student_subject ss on s.id = ss.id_student\n" +
            "where s.last_name =: studentName\n" +
            "group by concat(s.last_name, ' ', s.first_name)";

    public static final String STUDENT_HOCBONG_MAX = "" +
            "select  c.name as className,\n" +
            "        concat(s.first_name, ' ', s.last_name) as studentName\n" +
            "from student s\n" +
            "        left join student_subject ss on s.id = ss.id_student\n" +
            "        left join classes c on c.id = s.id_classes\n" +
            "order by s.hocbong DESC\n" +
            "limit 1";
}

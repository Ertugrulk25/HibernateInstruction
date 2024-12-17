package hb08.manytomany;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private Integer id;

    private String name;

    @ManyToMany (mappedBy = "courseList")//mappedBy kullanmazsak eğer course_Student08 isimli toplamda
    // 2 tane table oluşur(toplam 4 tablo,mappedBy olursa 3 tablo)

List<Student08> student08List = new ArrayList<>();

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student08> getStudent08List() {
        return student08List;
    }

    public void setStudent08List(List<Student08> student08List) {
        this.student08List = student08List;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}








package so.inspire.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.inspireso.framework.domain.BusinessObject;

/**
 * Created by Inspireso Tream
 */
@Entity
@Table(name = "user")
public class User extends BusinessObject {

    private String code;
    private String sex;
    private int age;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

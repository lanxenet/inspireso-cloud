package so.inspire.micservice.api.domain;

/**
 * Created by Inspireso Tream
 */
public class User {

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

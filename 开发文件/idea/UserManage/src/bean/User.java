package bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cmonesr
 * @date Wednesday 19 Jun 2019  14:00
 */
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String userPassword;
    private String phone;
    private Character gender;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public User() {
    }

    public User(String userName, String userPassword, String phone, Character gender, String address, Date birthday) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
    }

    public User(Integer id, String userName, String userPassword, String phone, Character gender, String address, Date birthday) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

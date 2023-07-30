package com.example.regist.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date age;
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, Date age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto(String firstName, String lastName, String phoneNumber, Date age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().equals("")){
            errors.rejectValue("firstName",null,"Không để trống tên");
        } else if (!userDto.getFirstName().matches("^[a-zA-Z]{5,45}$")){
            errors.rejectValue("firstName",null,"Firstname bắt buộc," +
                    " có độ dài tối thiểu 5, tối đa 45 ký tự, và chỉ là kí tự tiếng anh");
        }
        if (!userDto.getPhoneNumber().matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")){
            errors.rejectValue("phoneNumber",null,"Đặt số điện thoại theo đúng quy định với 10 số và bắt đầu bằng số 0");
        }
        if (userDto.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$")){
            errors.rejectValue("email",null,"Đặt email đúng định dạng user@gmail.com");
        }
        if (userDto.getAge()==null){
            errors.rejectValue("age",null,"Không để trống năm sinh");
        } else if(!checkAge(userDto.getAge())) {
            errors.rejectValue("age",null,"người đăng kí không được bé hơn 18 tuổi");
        }
    }
    public boolean checkAge(Date birthday){
        LocalDate localDate = LocalDate.now();
        LocalDate dob =birthday.toLocalDate();
        Period period =Period.between(dob,localDate);
        if (period.getYears()<18){
            return false;
        }else {
            return true;
        }
    }
}

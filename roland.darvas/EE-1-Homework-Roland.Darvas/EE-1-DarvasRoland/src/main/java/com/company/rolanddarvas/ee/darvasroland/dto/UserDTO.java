package com.company.rolanddarvas.ee.darvasroland.dto;

import com.company.rolanddarvas.ee.darvasroland.constraint.Address;
import com.company.rolanddarvas.ee.darvasroland.constraint.DateValid;
import com.company.rolanddarvas.ee.darvasroland.constraint.Email;
import com.company.rolanddarvas.ee.darvasroland.constraint.NameCheck;
import com.company.rolanddarvas.ee.darvasroland.constraint.Password;
import com.company.rolanddarvas.ee.darvasroland.constraint.Phone;
import com.company.rolanddarvas.ee.darvasroland.model.Gender;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author darvasr
 */
@NameCheck
@DateValid
public class UserDTO {

    @NotNull
    @Size(min = 6)
    private String username;

    @NotNull
    @Password
    private String password;

    private String firstName;

    private String lastName;

    @Address
    private String address;

    @Phone
    private String phone;

    @Email
    private String email;

    private Gender sex;

    @NotNull
    @Past
    private Date registrationDate;

    private Date dateOfBirth;

    private boolean admin;

    public UserDTO() {
        //to create json objects
    }

    private UserDTO(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.sex = builder.sex;
        this.registrationDate = builder.registrationDate;
        this.dateOfBirth = builder.dateOfBirth;
        this.admin = builder.admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static class Builder {

        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String address;
        private String phone;
        private String email;
        private Gender sex;
        private Date registrationDate;
        private Date dateOfBirth;
        private boolean admin;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder sex(Gender sex) {
            this.sex = sex;
            return this;
        }

        public Builder registrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}

package com.company.rolanddarvas.ee.darvasroland.dto;

import com.company.rolanddarvas.ee.darvasroland.annotation.ValidateBean;
import com.company.rolanddarvas.ee.darvasroland.constraint.*;
import com.company.rolanddarvas.ee.darvasroland.model.Gender;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author darvasr
 */
@NameCheck
@DateValid
@ValidateBean
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.password);
        hash = 41 * hash + Objects.hashCode(this.firstName);
        hash = 41 * hash + Objects.hashCode(this.lastName);
        hash = 41 * hash + Objects.hashCode(this.address);
        hash = 41 * hash + Objects.hashCode(this.phone);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.sex);
        hash = 41 * hash + Objects.hashCode(this.registrationDate);
        hash = 41 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 41 * hash + (this.admin ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDTO other = (UserDTO) obj;
        if (this.admin != other.admin) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
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

package model.user;

import java.time.LocalDate;

public class User {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthDate;

    public User (long id, String name, String surname, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", birthDate="
                + birthDate + "]";
    }
}

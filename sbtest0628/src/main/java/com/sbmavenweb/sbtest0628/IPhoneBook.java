package com.sbmavenweb.sbtest0628;

public interface IPhoneBook {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    EPhoneGroup getGroup();
    void setGroup(EPhoneGroup group);

    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);

    String getEmail();
    void setEmail(String email);
}

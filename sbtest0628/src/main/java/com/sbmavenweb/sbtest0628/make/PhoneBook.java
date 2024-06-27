package com.sbmavenweb.sbtest0628.make;

import com.sbmavenweb.sbtest0628.EPhoneGroup;
import com.sbmavenweb.sbtest0628.IPhoneBook;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder

public class PhoneBook implements IPhoneBook {
    private Long id;
    private String name;
    private EPhoneGroup group;
    private String phoneNumber;
    private String email;

    public PhoneBook() {
        this.id = 0L;
        this.name = "";
        this.group = null;
        this.phoneNumber = "";
        this.email = "";
    }

    public PhoneBook(Long id, String name, EPhoneGroup group, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("id:%6d, 이름:%s, 그룹:%s, 번호:%s, 이메일:%s",
                id, name, group, phoneNumber, email);

    }
}

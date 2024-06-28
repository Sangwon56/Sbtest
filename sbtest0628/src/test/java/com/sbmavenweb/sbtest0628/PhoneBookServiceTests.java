package com.sbmavenweb.sbtest0628;

import com.sbmavenweb.sbtest0628.make.PhoneBook;
import com.sbmavenweb.sbtest0628.make.PhoneBookServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookServiceTests {
    @Test
    public void phoneBookServiceImplTest() throws Exception {
        IPhoneBookService<IPhoneBook> jsonService = new PhoneBookServiceImpl("-j", "test.json");
        IPhoneBookService<IPhoneBook> textService = new PhoneBookServiceImpl("-t", "test.txt");
        File jsonFile = new File("test.json");
        File textFile = new File("test.txt");
        jsonFile.delete();
        textFile.delete();
        assertThat(jsonFile.exists()).isEqualTo(false);
        assertThat(textFile.exists()).isEqualTo(false);

        assertThat(jsonService.size()).isEqualTo(0);
        IPhoneBook jsonadd1 = PhoneBook.builder().id(1L).name("jsonadd1")
                .group(EPhoneGroup.Friends).phoneNumber("010-0000-0000")
                .email("add1@gmail.com").build();
        IPhoneBook jsonadd2 = PhoneBook.builder().id(2L).name("jsonadd2")
                .group(EPhoneGroup.Jobs).phoneNumber("010-1111-0000")
                .email("add2@gmail.com").build();
        IPhoneBook jsonadd3 = PhoneBook.builder().id(3L).name("jsonadd3")
                .group(EPhoneGroup.Hobbies).phoneNumber("010-1111-2222")
                .email("add3@gmail.com").build();

        IPhoneBook textadd1 = PhoneBook.builder().id(1L).name("textadd1")
                .group(EPhoneGroup.Friends).phoneNumber("010-0000-0000")
                .email("add1@gmail.com").build();
        IPhoneBook textadd2 = PhoneBook.builder().id(2L).name("textadd2")
                .group(EPhoneGroup.Jobs).phoneNumber("010-1111-0000")
                .email("add2@gmail.com").build();
        IPhoneBook textadd3 = PhoneBook.builder().id(3L).name("textadd3")
                .group(EPhoneGroup.Hobbies).phoneNumber("010-1111-2222")
                .email("add3@gmail.com").build();

        // insert test
        jsonService.insert(jsonadd1);
        textService.insert(textadd1);
        assertThat(jsonService.size()).isEqualTo(1);
        assertThat(textService.size()).isEqualTo(1);
        jsonService.insert(jsonadd2);
        jsonService.insert(jsonadd3);
        textService.insert(textadd2);
        textService.insert(textadd3);
        // size test
        assertThat(jsonService.size()).isEqualTo(3);
        assertThat(textService.size()).isEqualTo(3);
        // find test
        IPhoneBook find = jsonService.findById(1L);
        assertThat(find.getName()).isEqualTo("jsonadd1");
        assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Friends);
        assertThat(find.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(find.getEmail()).isEqualTo("add1@gmail.com");

        IPhoneBook find2 = textService.findById(2L);
        assertThat(find2.getName()).isEqualTo("textadd2");
        assertThat(find2.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        assertThat(find2.getPhoneNumber()).isEqualTo("010-1111-0000");
        assertThat(find2.getEmail()).isEqualTo("add2@gmail.com");

        // maxId test
        assertThat(jsonService.getMaxId()).isEqualTo(4L);
        assertThat(textService.getMaxId()).isEqualTo(4L);
        // remove test
        assertThat(jsonService.remove(2L)).isEqualTo(true);
        assertThat(jsonService.size()).isEqualTo(2);
        assertThat(textService.remove(2L)).isEqualTo(true);
        assertThat(textService.size()).isEqualTo(2);
        // getListFromName test
        assertThat(jsonService.getListFromName("add").size()).isEqualTo(2);
        assertThat(textService.getListFromName("add").size()).isEqualTo(2);

        // insert fields test
        jsonService.insert("add4", EPhoneGroup.Friends, "010-3333-4444", "add4@naver.com");
        assertThat(jsonService.size()).isEqualTo(3);
        assertThat(jsonService.getMaxId()).isEqualTo(4L);
        textService.insert("add4", EPhoneGroup.Friends, "010-3333-4444", "add4@naver.com");
        assertThat(textService.size()).isEqualTo(3);
        assertThat(textService.getMaxId()).isEqualTo(4L);
        // getListFromName test
        assertThat(jsonService.getListFromGroup(EPhoneGroup.Friends).size()).isEqualTo(2);
        assertThat(textService.getListFromGroup(EPhoneGroup.Friends).size()).isEqualTo(2);

        // save file test
        assertThat(jsonService.saveData()).isEqualTo(true);
        assertThat(textService.saveData()).isEqualTo(true);
        assertThat(jsonFile.exists()).isEqualTo(true);
        assertThat(jsonFile.length()).isEqualTo(306L);
        assertThat(textFile.exists()).isEqualTo(true);
        assertThat(textFile.length()).isEqualTo(140L);

        // load file test;
        jsonService.getAllList().clear();
        textService.getAllList().clear();
        assertThat(jsonService.size()).isEqualTo(0);
        assertThat(textService.size()).isEqualTo(0);
        assertThat(jsonService.loadData()).isEqualTo(true);
        assertThat(textService.loadData()).isEqualTo(true);
        assertThat(jsonService.size()).isEqualTo(3);
        assertThat(textService.size()).isEqualTo(3);
    }
}
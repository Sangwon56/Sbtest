package com.sbmavenweb.sbtest0628;

import com.sbmavenweb.sbtest0628.make.PhoneBook;
import com.sbmavenweb.sbtest0628.make.PhoneBookJsonRepository;
import com.sbmavenweb.sbtest0628.make.PhoneBookTextRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneBookRepositoryTests {
    @Test
    public void jsonRepositoryTest() throws Exception {
        PhoneBookJsonRepository repository = new PhoneBookJsonRepository("test.json");
        String json = "{\"phoneNumber\":\"010-1111-1111\",\"group\":\"Friends\",\"name\":\"장상원\",\"id\":5,\"email\":\"sw000506@naver.com\"}";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(json);
        IPhoneBook phoneBook = repository.getObjectFromJson((JSONObject)obj);
        assertThat(phoneBook.getId()).isEqualTo(5L);
        assertThat(phoneBook.getName()).isEqualTo("장상원");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Friends);
        assertThat(phoneBook.getGroup().toString()).isEqualTo("Friends");
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("010-1111-1111");
        assertThat(phoneBook.getEmail()).isEqualTo("sw000506@naver.com");

        IPhoneBook phoneBook2 = new PhoneBook();
        phoneBook2.setId(12L);
        phoneBook2.setName("상원");
        phoneBook2.setGroup(EPhoneGroup.Hobbies);
        phoneBook2.setPhoneNumber("010-1111-2222");
        phoneBook2.setEmail("sw000506@daum.net");
        JSONObject jobject = repository.getJsonFromObject(phoneBook2);
        assertThat((Long)jobject.get("id")).isEqualTo(12L);
        assertThat((String)jobject.get("name")).isEqualTo("상원");
        assertThat(EPhoneGroup.valueOf((String)jobject.get("group"))).isEqualTo(EPhoneGroup.Hobbies);
        assertThat((String)jobject.get("group")).isEqualTo("Hobbies");
        assertThat((String)jobject.get("phoneNumber")).isEqualTo("010-1111-2222");
        assertThat((String)jobject.get("email")).isEqualTo("sw000506@daum.net");
        assertThat(jobject.toJSONString()).isEqualTo("{\"phoneNumber\":\"010-1111-2222\",\"name\":\"상원\",\"id\":12,\"email\":\"sw000506@daum.net\",\"group\":\"Hobbies\"}");
    }

    @Test
    public void textRepositoryTest() throws Exception {
        PhoneBookTextRepository repository = new PhoneBookTextRepository("test.txt");
        Throwable ex = assertThrows(Exception.class, () -> repository.getObjectFromText(""));
        System.out.println(ex.toString());

        IPhoneBook phoneBook = repository.getObjectFromText("1 홍길동 Families 010-1111-1111 abcd@gmail.com");
        assertThat(phoneBook.getId()).isEqualTo(1L);
        assertThat(phoneBook.getName()).isEqualTo("홍길동");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Families);
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("010-1111-1111");
        assertThat(phoneBook.getEmail()).isEqualTo("abcd@gmail.com");

        String str = repository.getTextFromObject(phoneBook);
        assertThat(str).isEqualTo("1 홍길동 Families 010-1111-1111 abcd@gmail.com\n");
    }
}

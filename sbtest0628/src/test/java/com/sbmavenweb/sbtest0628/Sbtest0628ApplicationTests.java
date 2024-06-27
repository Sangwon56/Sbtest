//package com.sbmavenweb.sbtest0628;
//
//import com.sbmavenweb.sbtest0628.make.PhoneBook;
//import com.sbmavenweb.sbtest0628.make.PhoneBookJsonRepository;
//import com.sbmavenweb.sbtest0628.make.PhoneBookTextRepository;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThrows;
//
//
//public class Sbtest0628ApplicationTests {
//
//    @Test
//    public void jsonRepositoryTest() throws Exception {
//        PhoneBookJsonRepository repository = new PhoneBookJsonRepository("test.json");
//
//        String json ="{\"phoneNumber\":\"123949\",\"name\":\"이말자\",\"id\":3,\"email\":\"asdfs@gmcom\",\"group\":\"Families\"}";
//        JSONParser parser = new JSONParser();
//        IPhoneBook object = null;
//
//        Object obj = parser.parse(json);
//
//        object = repository.getObjectFromJson((JSONObject)obj);
//        assertThat(object.getId()).isEqualTo(3L);
//        assertThat(object.getName()).isEqualTo("이말자");
//        assertThat(object.getGroup()).isEqualTo(EPhoneGroup.Families);
//        assertThat(object.getPhoneNumber()).isEqualTo("123949");
//        assertThat(object.getEmail()).isEqualTo("asdfs@gmcom");
//
//        IPhoneBook iPhoneBook = new PhoneBook();
//        iPhoneBook.setId(88L);
//        iPhoneBook.setName("폰북");
//        iPhoneBook.setGroup(EPhoneGroup.Hobbies);
//        iPhoneBook.setPhoneNumber("010-1111-1111");
//        iPhoneBook.setEmail("sw@mail.com");
//        JSONObject jobj = repository.getJsonFromObject(iPhoneBook);
//
//        assertThat((Long)jobj.get("id")).isEqualTo(88L);
//        assertThat((String)jobj.get("name")).isEqualTo("폰북");
//        assertThat(jobj.get("group")).isEqualTo(EPhoneGroup.Hobbies);
//        assertThat((String)jobj.get("phoneNumber")).isEqualTo("010-1111-1111");
//        assertThat((String)jobj.get("email")).isEqualTo("sw@mail.com");
//    }
//
//    @Test
//    public void TextRepositoryTest() throws Exception {
//        PhoneBookTextRepository repository = new PhoneBookTextRepository("test.txt");
//        Throwable ex = assertThrows(Exception.class, () -> repository.getObjectFromText(""));
//        System.out.println(ex.toString());
//
//        IPhoneBook phoneBook = repository.getObjectFromText("1,장상원,Friends,55556666,sw0506@mail.com");
//        assertThat(phoneBook.getId()).isEqualTo(1);
//        assertThat(phoneBook.getName()).isEqualTo("장상원");
//        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Friends);
//        assertThat(phoneBook.getPhoneNumber()).isEqualTo("55556666");
//        assertThat(phoneBook.getEmail()).isEqualTo("sw0506@mail.com");
//
//        String str = "1,길길동,Friends,12341234,askie@gis.com";
//        assertThat(str).isEqualTo("1,길길동,Friends,12341234,askie@gis.com");
//    }
//
//}

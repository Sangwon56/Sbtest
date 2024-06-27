package com.sbmavenweb.sbtest0628;

import java.util.List;

public interface IPhoneBookService<IPhoneBook> {
    int size();

    Long getMaxId();

    IPhoneBook findById(Long id);

    List<IPhoneBook> getAllList();

    boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception;

    boolean insert(IPhoneBook phoneBook) throws Exception;

    boolean remove(Long id) throws Exception;

    boolean update(Long id, IPhoneBook phoneBook) throws Exception;

    List<IPhoneBook> getListFromName(String findName);

    List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup);

    List<IPhoneBook> getListFromPhoneNumber(String findPhone);

    List<IPhoneBook> getListFromEmail(String findEmail);

    boolean loadData() throws Exception;

    boolean saveData() throws Exception;
}

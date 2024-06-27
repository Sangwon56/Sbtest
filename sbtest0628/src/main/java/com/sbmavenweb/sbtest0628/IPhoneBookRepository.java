package com.sbmavenweb.sbtest0628;

import java.util.List;

public interface IPhoneBookRepository<T> {
    boolean saveData(List<T> listData) throws Exception;
    boolean loadData(List<T> listData) throws Exception;
}

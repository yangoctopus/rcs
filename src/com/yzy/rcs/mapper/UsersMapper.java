package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.Users;

import java.util.List;

public interface UsersMapper {
    Users login(Users users);
    List<Users> loadAll(Users users);

   List<Users> findKey(String keywords);
   void saveUsers(Users users);

    void updateUsers(Users users);

    void delUsers(Users users);
}

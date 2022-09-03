package com.rpg.repository;


import com.rpg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickName(String userName);

    Integer countByNickName(String nickName);

    Integer countByEmail(String email);

    Integer countByPhone(String phone);

}
//Test

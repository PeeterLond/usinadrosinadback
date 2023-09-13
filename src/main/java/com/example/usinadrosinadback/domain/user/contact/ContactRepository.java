package com.example.usinadrosinadback.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select (count(c) > 0) from Contact c where c.user.username = ?1")
    boolean contactExistsBy(String username);

    @Query("select c from Contact c where c.user.id = ?1")
    Contact getContactBy(Integer userId);


}
package com.wtongze.innospace.service;

import com.wtongze.innospace.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudRepository<User, String> {
}

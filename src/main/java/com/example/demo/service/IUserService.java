package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserService {
	List<Map> save(String id, String email, String password, String phone, String avatar) throws SQLException;
}

package com.example.demo.service.impl;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.error.exception.OracleException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import com.example.demo.util.AppParams;
import com.example.demo.util.DBProcedureUtil;
import com.example.demo.util.ParamUtil;

import io.netty.handler.codec.http.HttpResponseStatus;
import oracle.jdbc.OracleTypes;

@Service
public class UserService implements IUserService {
	
	protected static DataSource dataSource;
	
	@Autowired
	private UserRepository userRepository;

	public static final String INSERT_USER = "{call PKG_REGISTER.insert_user(?,?,?,?,?,?,?)}";

	
	public static List<Map> excuteQuery(String query, Object[] args) throws SQLException {
        int beginIdx = 0;
        Map inArgs = new LinkedHashMap<>();
        if (args != null && args.length > 0) {
            for (int i = 1; i <= args.length; i++) {
                inArgs.put(i, args[i - 1]);
            }
            beginIdx = args.length;
        }

        Map<Integer, Integer> outTypes = new LinkedHashMap<>();
        outTypes.put(beginIdx + 1, OracleTypes.NUMBER);
        outTypes.put(beginIdx + 2, OracleTypes.VARCHAR);
        outTypes.put(beginIdx + 3, OracleTypes.CURSOR);

        Map<Integer, String> outNames = new LinkedHashMap<>();
        outNames.put(beginIdx + 1, AppParams.RESULT_CODE);
        outNames.put(beginIdx + 2, AppParams.RESULT_MSG);
        outNames.put(beginIdx + 3, AppParams.RESULT_DATA);

        Map queryResult = DBProcedureUtil.execute(dataSource, query, inArgs, outTypes, outNames);

        int resultCode = ParamUtil.getInt(queryResult, AppParams.RESULT_CODE);

        if (resultCode != HttpResponseStatus.OK.code() && resultCode != HttpResponseStatus.CREATED.code()) {
            throw new OracleException(ParamUtil.getString(queryResult, AppParams.RESULT_MSG));
        }

        List<Map> queryDataList = ParamUtil.getListData(queryResult, AppParams.RESULT_DATA);

        return queryDataList;
    }




	@Override
	public List<Map> save(String id, String email, String password, String phone, String avatar) throws SQLException {
		// TODO Auto-generated method stub
		return excuteQuery(INSERT_USER, new Object[] {id, email, password, phone, avatar});
	}
}

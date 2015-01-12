package com.blende.support;

import com.blende.model.Person;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface AuthenticationService {

    boolean authenticate(String user, String password) throws NoSuchAlgorithmException, SQLException;

    Person createUser(Person user)
            throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException;

    byte[] getHash(String password, byte[] salt)  throws NoSuchAlgorithmException, UnsupportedEncodingException;

}

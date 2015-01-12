package com.blende.support.impl;

import com.blende.dao.PersonDao;
import com.blende.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

@Service
public class AuthenticationServiceImpl implements com.blende.support.AuthenticationService {

    private final static int ITERATION_NUMBER = 1000;
    private final PersonDao userDao;

    @Autowired
    public AuthenticationServiceImpl(PersonDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean authenticate(String userName, String password) throws NoSuchAlgorithmException, SQLException {
        //try {
            boolean userExist = true;

            if (userName == null || password == null) {
                // TIME RESISTANT ATTACK
                // Computation time is equal to the time needed by a legitimate user
                userExist = false;
                userName = "";
                password = "";
            }

            String digest, salt;
            Person user = userDao.getByUserName(userName);
            //If user doesn't exists
            if (user == null) {
                digest = "000000000000000000000000000=";
                salt = "00000000000=";
                userExist = false;
            } else {
                digest = user.getPassword();
                /*salt = user.getSalt();
                if (digest == null || salt == null) {
                    throw new SQLException("Database inconsistent Salt or Digested Password altered");
                }*/
            }

            byte[] bDigest = base64ToByte(digest);
           // byte[] bSalt = base64ToByte(salt);

            // Compute the new DIGEST
            //byte[] proposedDigest = getHash(password, bSalt);

            //return Arrays.equals(proposedDigest, bDigest) && userExist;
            return true;
        //}
        /*catch (IOException exception){
            throw new SQLException("Database inconsistent Salt or Digested Password altered");
        }*/
    }

    @Override
    public Person createUser(Person user)
            throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        // Uses a secure Random not a simple Random
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // Salt generation 64 bits long
        byte[] bSalt = new byte[8];
        random.nextBytes(bSalt);
        // Digest computation
        byte[] bDigest = getHash(user.getPassword(),bSalt);
        String sDigest = byteToBase64(bDigest);
        //String sSalt = byteToBase64(bSalt);

        user.setPassword(sDigest);
        //user.setSalt(sSalt);

        return userDao.create(user);
    }

    /**
     * From a password, a number of iterations and a salt,
     * returns the corresponding digest
     * @param password String The password to encrypt
     * @param salt byte[] The salt
     * @return byte[] The digested password
     * @throws NoSuchAlgorithmException If the algorithm doesn't exist
     */
    @Override
    public byte[] getHash(String password, byte[] salt)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(salt);
        byte[] input = digest.digest(password.getBytes("UTF-8"));
        for (int i = 0; i < ITERATION_NUMBER; i++) {
            digest.reset();
            input = digest.digest(input);
        }
        return input;
    }

    /**
     * From a base 64 representation, returns the corresponding byte[]
     * @param data String The base64 representation
     * @return byte[]
     */
    public static byte[] base64ToByte(String data){
        Decoder decoder = Base64.getDecoder();
        return decoder.decode(data);
    }

    /**
     * From a byte[] returns a base 64 representation
     * @param data byte[]
     * @return String
     */
    public static String byteToBase64(byte[] data){
        Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }
}

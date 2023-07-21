package com.tiwari.studence.util.encoder;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptor {

  public static String encryptPassword(String password) {
    // Generate a random salt
    String salt = BCrypt.gensalt();

    // Hash the password using bcrypt
    String hashedPassword = BCrypt.hashpw(password, salt);

    return hashedPassword;
  }

  public static boolean verifyPassword(String password, String hashedPassword) {
    // Verify the entered password against the hashed password
    boolean passwordMatches = BCrypt.checkpw(password, hashedPassword);

    return passwordMatches;
  }

}

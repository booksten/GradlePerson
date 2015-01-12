package com.blende.support;

import org.springframework.security.core.Authentication;

public interface AuthenticationInfo {
    Authentication getAuthentication();
    String getUserName();
}

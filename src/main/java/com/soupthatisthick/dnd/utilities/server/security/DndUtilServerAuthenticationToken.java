package com.soupthatisthick.dnd.utilities.server.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Owner on 9/9/2017.
 */
@SuppressWarnings("WeakerAccess")
public class DndUtilServerAuthenticationToken implements Authentication {

    private boolean auth = true;
    private final Object credentials;
    private final Object details;
    private final Object principal;
    private final String name;

    public DndUtilServerAuthenticationToken() {
        this("credentials", "details", "principal", "name");
    }

    public DndUtilServerAuthenticationToken(
            final Object credentials,
            final Object details,
            final Object principal,
            final String name
    ) {
        this.credentials = credentials;
        this.details = details;
        this.principal = principal;
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return auth;   // By default we are authenticated
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.auth = isAuthenticated;
    }

    @Override
    public String getName() {
        return name;
    }
}
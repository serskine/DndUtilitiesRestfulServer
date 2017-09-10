package com.soupthatisthick.dnd.utilities.server.security;

import com.soupthatisthick.dnd.utilities.server.util.logger.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by Owner on 9/9/2017.
 */
@Component
public class DndUtilServerAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Logger.warning("DndUtilServerAuthenticationProvider: entry");

        DndUtilServerAuthenticationToken authenticationToken = (DndUtilServerAuthenticationToken) authentication;

        authentication.setAuthenticated(true);

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return DndUtilServerAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

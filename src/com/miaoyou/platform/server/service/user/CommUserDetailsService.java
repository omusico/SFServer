/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.service.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miaoyou.platform.server.entity.common.CommUserDetails;
import com.miaoyou.platform.server.utils.ToolHelper;
import com.miaoyou.platform.server.utils.UnicodeConverter;

/**
 *
 * @author 305027939
 */
@Service
public class CommUserDetailsService extends AbstractUserDetailsAuthenticationProvider {

    private static final Log log = LogFactory.getLog(CommUserDetailsService.class);

    private LoginUserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder;

    private SaltSource saltSource;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        Object salt = null;

        if (this.getSaltSource() != null) {
            salt = this.getSaltSource().getSalt(userDetails);
        }

        if (authentication.getCredentials() == null) {
            log.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException("Bad credentials:" + userDetails);
        }

        String presentedPassword = new String(ToolHelper.encryptBASE64(authentication.getCredentials().toString().getBytes()));

        if (!presentedPassword.equals(userDetails.getPassword())) {
            log.error("Authentication failed: password does not match stored value,userDetails:"+userDetails.getPassword()+",presentedPassword:"+presentedPassword);
            throw new BadCredentialsException("Bad credentials:" + userDetails);
        }

//        if (!passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
//            log.debug("Authentication failed: password does not match stored value");
//            throw new BadCredentialsException("Bad credentials:" + userDetails);
//        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        CommUserDetails loadedUser;
        try {
            String realUserName = UnicodeConverter.fromEncodedUnicode(username.toCharArray(), 0, username.length());
            log.info("retrieveUser,UnicodeConverter from :" + username + " to :" + realUserName);
            String password = (String) authentication.getCredentials();
            loadedUser = getUserDetailsService().loadUserByUsername(realUserName, password);
            log.info(loadedUser.getUsername() + " logined.");
        } catch (UsernameNotFoundException notFound) {
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    /**
     * @return the userDetailsService
     */
    public LoginUserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    /**
     * @param userDetailsService the userDetailsService to set
     */
    public void setUserDetailsService(LoginUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * @return the passwordEncoder
     */
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    /**
     * @param passwordEncoder the passwordEncoder to set
     */
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @return the saltSource
     */
    public SaltSource getSaltSource() {
        return saltSource;
    }

    /**
     * @param saltSource the saltSource to set
     */
    public void setSaltSource(SaltSource saltSource) {
        this.saltSource = saltSource;
    }

}

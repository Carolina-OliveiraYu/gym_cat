package br.com.ibm.feminisbackend.service;

import br.com.ibm.feminisbackend.dto.AuthenticateUserData;
import br.com.ibm.feminisbackend.entity.AuthenticateUser;
import br.com.ibm.feminisbackend.repository.AuthenticateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAuthenticateUserService implements AuthenticateUserService {

    @Autowired
    private AuthenticateUserRepository authenticateUserRepository;

    @Override
    public AuthenticateUserData saveAuthenticateUser(AuthenticateUserData authenticateUserData) {
        try {
            AuthenticateUser authenticateUser = populateUserEntity(authenticateUserData);
            return populateUserData(authenticateUserRepository.save(authenticateUser));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean deleteAuthenticateUser(Long id) {
        try {
            authenticateUserRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public AuthenticateUserData loginAuthenticateUser(String username, String password) {
        try {
            AuthenticateUser auth = authenticateUserRepository.getAuthenticateUser(username, password);
            if (auth.getId() != null) {
                return populateUserData(auth);
            }else {
                return null;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @param authenticateUser
     * @return
     */
    private AuthenticateUserData populateUserData(final AuthenticateUser authenticateUser) {
        AuthenticateUserData authenticateUserData = new AuthenticateUserData();
        authenticateUserData.setId(authenticateUser.getId());
        authenticateUserData.setUsername(authenticateUser.getUsername());
        authenticateUserData.setPassword(authenticateUser.getPassword());
        return authenticateUserData;
    }

    /**
     * @param authenticateUserData
     * @return
     */
    private AuthenticateUser populateUserEntity(AuthenticateUserData authenticateUserData) {
        AuthenticateUser authenticateUser = new AuthenticateUser();
        authenticateUser.setId(authenticateUserData.getId());
        authenticateUser.setUsername(authenticateUserData.getUsername());
        authenticateUser.setPassword(authenticateUserData.getPassword());
        return authenticateUser;
    }

}

package br.com.ibm.feminisbackend.controller;

import br.com.ibm.feminisbackend.dto.AuthenticateUserData;
import br.com.ibm.feminisbackend.service.IAuthenticateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authUser")
public class AuthenticateUserController {

    @Autowired
    private IAuthenticateUserService authenticateUserService;

    /**
     * @param authenticateUserData
     * @return
     */
    @RequestMapping(path = "/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAuthenticateUser(final @RequestBody AuthenticateUserData authenticateUserData) {
        try {
            authenticateUserService.saveAuthenticateUser(authenticateUserData);
            return new ResponseEntity<>("Salvo com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Falha ao salvar usuario por favor tente novamente!", HttpStatus.BAD_REQUEST);

        }
    }

    /**
     * @param authenticateUserData
     * @return
     */
    @RequestMapping(path = "/loginUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticateUserData> logAuthenticateUser(
            final @RequestBody AuthenticateUserData authenticateUserData) {
        try {
            AuthenticateUserData auth = authenticateUserService.loginAuthenticateUser(
                    authenticateUserData.getUsername(),
                    authenticateUserData.getPassword());
            if (auth.getId() != null) {
                return new ResponseEntity<AuthenticateUserData>(auth, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<AuthenticateUserData>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(path = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAuthenticateUser(@PathVariable Long id) {
        try {
            authenticateUserService.deleteAuthenticateUser(id);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Falha ao deletar usuario por favor tente novamente!", HttpStatus.BAD_REQUEST);
        }
    }
}

package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        //TODO: add corresponding log message about method login was called
        logger.info("method login was called with login login= {}", login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.error("Username or password are incorrect. userLogin: user = {}", user.getLogin());
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User was login");
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        logger.info("Method findByLogin was called for user with id userId= {}", user.getUserId());
        return user;
    }
}

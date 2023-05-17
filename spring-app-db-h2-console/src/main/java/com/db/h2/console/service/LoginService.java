package com.db.h2.console.service;

import com.db.h2.console.DTO.LoginDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.Login;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.LoginRepository;
import entityToDTO.LoginEntityToDTO;
import entityToDTO.PersonExerciseEntityToDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class LoginService {

    private LoginRepository loginRepository;
    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public List<Login> list() {
        return loginRepository.findAll();
    }

    public Login buildDefaultLogin() {
        Long maxId = this.loginRepository.getMaxLoginId();
        String user = "test%s@test.com";
        String password = "test%spassword";
        if (maxId == null) {
            maxId = 0L;
        }
        maxId++;
        Login login = this.loginRepository.save(createLogin(
                String.format(user, maxId), String.format(password, maxId)));
        return login;
    }

    private Login createLogin(String userid, String password) {
        Login login = new Login();
        login.setUserid(userid);
        login.setPassword(password);
        login.setCreatedBy("I-Am");
        login.setModifiedBy("I-Am");
        login.setBirthday(LocalDate.of(1981, 12, 10));
        login.setCreatedDate(LocalDateTime.parse("2023-01-01T00:00:00"));
        login.setModifiedDate(LocalDateTime.of(2023, 5, 1,
                8, 0, 0));

        return login;
    }

    public LoginDTO sigupLogin(LoginDTO loginDTO) {
        System.err.println("sigupLogin: "+loginDTO);
        Long maxId = this.loginRepository.getMaxLoginId();

//        if (login.getId() == null || login.getId() == 0) {
//            Long maxId = this.loginRepository.getMaxLoginId();
//            return this.loginRepository.save(createLogin(
//                    String.format(login.getUserid(), maxId), String.format(login.getPassword(), maxId)));
//        }
//        loginRepository.findById(loginDTO.getId());
//        Login saveLogin = loginRepository.save(login);
//        return saveLogin;

        System.err.println("LoginDTO >> " + loginDTO);

        Login login = modelMapper.map(loginDTO, Login.class);
        System.err.println("login.getId() >> " + login.getId());
        System.err.println("login >> " + login);

        Login createLogin = this.loginRepository.save(createLogin(
                String.format(login.getUserid(), maxId), String.format(login.getPassword(), maxId)));
        System.err.println("createLogin >> " + createLogin);
        Login updateLogin = loginRepository.save(createLogin);

        LoginEntityToDTO loginEntityToDTO = new LoginEntityToDTO();
        LoginDTO updateLoginDTO = loginEntityToDTO.convertLogin(updateLogin);
        System.err.println("updateLoginDTO >> " + updateLoginDTO);

        System.err.println("updateLoginDTO.getId() >> " + updateLoginDTO.getId());
        System.err.println("updateLoginDTO >> " + updateLoginDTO);

        return updateLoginDTO;
    }

}

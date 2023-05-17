package entityToDTO;

import com.db.h2.console.DTO.LoginDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.Login;
import com.db.h2.console.domain.PersonExercise;
import org.modelmapper.ModelMapper;


public class LoginEntityToDTO {

    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * see https://modelmapper.org/getting-started/
     */
    public LoginDTO convertLogin(Login login) {
        LoginDTO loginDTO = modelMapper.map(login, LoginDTO.class);
        System.err.println("loginDTO >> " + loginDTO);
        return loginDTO;
    }
}

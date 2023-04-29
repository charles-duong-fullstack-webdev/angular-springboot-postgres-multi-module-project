package entityToDTO;

import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.PersonExercise;
import org.modelmapper.ModelMapper;


public class PersonExerciseEntityToDTO {

    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * see https://modelmapper.org/getting-started/
     */
    public PersonExerciseDTO convertPersonExercise(PersonExercise personExercise) {
        PersonExerciseDTO personExerciseDTO = modelMapper.map(personExercise, PersonExerciseDTO.class);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);
        return personExerciseDTO;
    }
}

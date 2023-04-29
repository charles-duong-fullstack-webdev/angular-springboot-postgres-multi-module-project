package entityToDTO;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.domain.Exercise;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class ExerciseEntityToDTO {

    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * 2.2. Type Token
     * see https://www.baeldung.com/java-modelmapper-lists
     * <p>
     * ModelMapper uses TypeToken to map generic types. To see why this is necessary,
     * let's see what happens when we map an Integer list to a Character list:
     * <p>
     * List<Integer> integers = new ArrayList<Integer>();
     * integers.add(1);
     * integers.add(2);
     * integers.add(3);
     * <p>
     * List<Character> characters = new ArrayList<Character>();
     * modelMapper.map(integers, characters);
     * Copy
     * Further, if we print out the elements of the characters list we would see an empty list.
     * This is due to the occurrence of type erasure during runtime execution.
     * <p>
     * If we change our map call to use TypeToken, though, we can create a type literal for List<Character>:
     * <p>
     * List<Character> characters
     * = modelMapper.map(integers, new TypeToken<List<Character>>() {}.getType());
     * Copy
     * At compile time, the TokenType anonymous inner case preserves the List<Character> parameter type,
     * and this time our conversion is successful.
     */
    public List<ExerciseDTO> convertExercise(List<Exercise> exerciseENTITYs) {

        // Without using "Type Token" will give 0 size (exerciseDTOs.size >> 0)
        List<ExerciseDTO> exerciseDTOs = new ArrayList<ExerciseDTO>();
        modelMapper.map(exerciseENTITYs, exerciseDTOs);
        System.err.println("exerciseDTOs.size >> " + exerciseDTOs.size());

        // Use "Type Token" will give 4 size (exerciseDTOTypeTokens.size >> 4)
        List<ExerciseDTO> exerciseDTOTypeTokens = modelMapper.map(exerciseENTITYs,
                new TypeToken<List<ExerciseDTO>>() {
                }.getType());
        // Sucessful: exerciseDTOTypeTokens.size >> 4
        System.err.println("exerciseDTOTypeTokens.size >> " + exerciseDTOTypeTokens.size());
        System.err.println("exerciseDTOTypeTokens >> " + exerciseDTOTypeTokens);

        return exerciseDTOTypeTokens;
    }
}

package ma.ac.supmti.pfe.exception;

import java.util.List;

public class InvalidLessonModelException extends RuntimeException {

    private final List<String> lessonErrors;

    public InvalidLessonModelException(List<String> errors) {
        super();
        this.lessonErrors = errors;
    }

    public List<String> getLessonErrors() {
        return lessonErrors;
    }


}

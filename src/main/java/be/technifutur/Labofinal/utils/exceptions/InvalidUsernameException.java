package be.technifutur.Labofinal.utils.exceptions;

public class InvalidUsernameException extends RuntimeException{

    public InvalidUsernameException() {
        super("the username used is not linked to a user");
    }

}

package be.technifutur.Labofinal;

public class InvalidUsernameException extends RuntimeException{

    public InvalidUsernameException() {
        super("the username used is not linked to a user");
    }

}

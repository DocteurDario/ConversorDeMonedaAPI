package excepcion;

public class ErrorExcepcion extends RuntimeException{
    private String Message ;

    public ErrorExcepcion(String Message){
        this.Message = Message ;
    }

    @Override
    public String getMessage() {
        return this.Message;
    }

}

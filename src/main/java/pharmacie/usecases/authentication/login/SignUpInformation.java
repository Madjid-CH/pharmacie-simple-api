package pharmacie.usecases.authentication.login;


public record SignUpInformation(
        String username,
        String Name,
        String LastName,
        String Password
) { }

package ch.heigvd;

import java.io.File;

import ch.heigvd.commands.Hello;
import ch.heigvd.commands.Goodbye;
import picocli.CommandLine;

@CommandLine.Command(
        description = "A small CLI with subcommands to demonstrate picocli.",
        version = "1.0.0",
        showDefaultValues = true,
        subcommands = {
                Hello.class,
                Goodbye.class
        },
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true
)
public class Main {

    @CommandLine.Parameters(
            index = "0",
            description = "The name of the user.",
            defaultValue = "World")
    protected String name;

    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        // Source: https://stackoverflow.com/a/11159435
        String jarFilename =
                new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                        .getName();

        int exitCode = new CommandLine(new Main()).setCommandName(jarFilename).execute(args);

        System.exit(exitCode);
    }
}
package ch.heigvd.commands;

import ch.heigvd.Main;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "goodbye", description = "Print a goodbye world message.")
public class Goodbye implements Callable<Integer> {
    @CommandLine.ParentCommand protected Main parent;

    @CommandLine.Option(
            names = {"-f", "--farewells"},
            description = "The farewell to address the user.",
            defaultValue = "Goodbye"
    )
    protected String farewells;

    @Override
    public Integer call() {
        System.out.println(farewells + " " + parent.getName() + "!");
        return 0;
    }
}

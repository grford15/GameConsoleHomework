import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.Console;
import models.Games;
import models.Genre;
import models.Region;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Console ps4 = new Console("Sony", "PS4", Region.EUROPE);
        DBHelper.save(ps4);
        Console xbox = new Console("Microsoft", "XBox", Region.AMERICA);
        DBHelper.save(xbox);

        Games gow = new Games("God of War", Genre.ADVENTURE, 18);
        DBHelper.save(gow);
        Games fifa = new Games("Fifa 2019", Genre.SPORTS, 12);
        DBHelper.save(fifa);
        Games cod = new Games("Call of Duty", Genre.FPS, 18);
        DBHelper.save(cod);
        Games assassin = new Games("Assassins Creed", Genre.RPG, 18);
        DBHelper.save(assassin);

        DBConsole.addGameToConsole(gow, ps4);
        DBConsole.addGameToConsole(fifa, ps4);
        DBConsole.addGameToConsole(fifa, xbox);
        DBConsole.addGameToConsole(cod, ps4);
        DBConsole.addGameToConsole(cod, xbox);
        DBConsole.addGameToConsole(assassin, xbox);

        List<Games> allGames = DBHelper.getAll(Games.class);

        List<Console> allConsoles = DBHelper.getAll(Console.class);

        List<Games> ps4Games = DBConsole.availableGames(ps4);

        List<Console> fifaConsoles = DBGame.getConsoles(fifa);

    }

}

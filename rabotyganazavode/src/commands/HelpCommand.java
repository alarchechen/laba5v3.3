package commands;

import exceptions.InvalidCommandArgumentsException;
import exceptions.OperationCancelledException;
import java.util.Map;

/**
 * Команда help выводит список доступных команд.
 * Список команд определяется динамически на основе карты команд,
 * переданной через сеттер.
 */
public class HelpCommand implements Command {
    private Map<String, Command> commands; // Карта команд, которую устанавливает CommandHandler

    // Публичный конструктор без параметров
    public HelpCommand() {
    }

    /**
     * Внедряет зависимость: карту команд.
     *
     * @param commands карта, где ключ – имя команды, а значение – объект команды
     */
    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        if (commands == null || commands.isEmpty()) {
            System.out.println("Список команд пуст.");
            return;
        }
        System.out.println("Доступные команды:");
        // Динамически выводим имена всех команд
        for (String commandName : commands.keySet()) {
            System.out.println("- " + commandName);
        }
    }

    @Override
    public String toString() {
        return "help";
    }
}

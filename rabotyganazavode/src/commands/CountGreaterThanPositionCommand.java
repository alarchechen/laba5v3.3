package commands;

import service.WorkerService;
import input.InputManager;
import model.Position;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;
import java.util.Arrays;

//Команда count_greater_than_position выводит количество работников с позицией выше заданной.
public class CountGreaterThanPositionCommand implements Command {
    private WorkerService service;
    private InputManager inputManager;

    public CountGreaterThanPositionCommand() {
        // Пустой конструктор
    }

    public void setWorkerService(WorkerService service) {
        this.service = service;
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void execute(String args) throws OperationCancelledException, InvalidCommandArgumentsException {
        System.out.println("Доступные позиции: " + Arrays.toString(Position.values()));
        Position pos = inputManager.getEnum(Position.class, "Введите позицию для сравнения: ");
        service.countGreaterThanPosition(pos);
    }

    @Override
    public String toString() {
        return "count_greater_than_position";
    }
}

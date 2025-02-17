package commands;

import service.WorkerService;
import input.InputManager;
import model.Worker;
import exceptions.OperationCancelledException;
import exceptions.InvalidCommandArgumentsException;


public class UpdateCommand implements Command {
    private WorkerService service;
    private InputManager inputManager;

    public UpdateCommand() {
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
        try {
            long id = Long.parseLong(args.trim());
            if (!service.containsWorker(id)) {
                System.out.println("Работник с ID " + id + " не найден.");
                return;
            }
            Worker updatedWorker = WorkerCreator.createWorker(inputManager);
            service.update(id, updatedWorker);
            System.out.println("Работник с ID " + id + " обновлён.");
        } catch (NumberFormatException e) {
            throw new InvalidCommandArgumentsException("ID должен быть числом.");
        }
    }

    @Override
    public String toString() {
        return "update";
    }
}

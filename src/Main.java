import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        Scanner scanner = new Scanner(System.in);
        int n;
        int m;
        int f;
        System.out.println("Hello!");

        while (true) {
            try {
                logger.log("Просим пользователя ввести размер списка");
                System.out.print("Введите размер списка (целое положительное число): ");
                String s1 = scanner.nextLine();
                n = Integer.parseInt(s1);
                if (n < 0 || n == 0) {
                    logger.log("Введено некорректное значение размера списка");
                }
                if (n > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число для размера списка");
                logger.log("Ошибка. Введено не целое число для размера списка");
            }
        }

        while (true) {
            try {
                logger.log("Просим пользователя ввести верхнюю границу значений");
                System.out.print("Введите верхнюю границу для значений (целое положительное число): ");
                String s2 = scanner.nextLine();
                m = Integer.parseInt(s2);
                if (m < 0 || m == 0) {
                    logger.log("Введено некорректное значение верхней границы значений"); //для предотвращения
                    // ошибки в момент заполнения списка
                }
                if (m > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое положительное число для верхней границы значений");
                logger.log("Ошибка. Введено не целое число для верхней границы значений");
            }
        }

        logger.log("Создаем и наполняем список");
        List<Integer> list = new ArrayList<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(i, random.nextInt(m));
        }

        System.out.print("Вот случайный список: ");// + list.toString().replaceAll("^\\[|\\]$", "" ));
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        while (true) {
            try {
                logger.log("Просим пользователя ввести входные данные для фильтрации");
                System.out.print("Введите целое число для фильтрации списка: ");
                String s3 = scanner.nextLine();
                f = Integer.parseInt(s3);
                if (f < 0 || f == 0) { // наверно можно поставить и отрицательное значение, тогда просто не подойдет весь список
                    logger.log("Введено некорректное значение для фильтрации");
                }
                if (f > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число для фильтра");
                logger.log("Ошибка. Введено не целое число для фильтра");
            }
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(f);
        List<Integer> result = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result.toString().replaceAll("^\\[|\\]$", " "));

        logger.log("Завершаем программу");
    }
}

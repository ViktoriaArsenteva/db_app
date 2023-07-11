import java.util.Random;
import java.util.Scanner;

public class Program {


    private static final  int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static final Random random = new Random();

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize(){
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;


        field = new char[fieldSizeX][fieldSizeY];
        // Пройдем по всем элементам массива
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * //TODO: Поправить отрисовку игрового поля
     */
    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++){
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++){
            System.out.print(i + 1 + "|");

            for (int j = 0; j <  fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn(){
        int x, y;
        do
        {
            System.out.print("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива, игрового поля)
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 &&  x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    private static void aiTurn(){
        System.out.println("w");
        int x, y;
        boolean check = false;
        for (int i = 0; i < fieldSizeX; i++){
            if (check == true){break;}
            for (int j = 0; j < fieldSizeY; j++){
                if (isCellEmpty(i, j)){
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI,WIN_COUNT,fieldSizeX,fieldSizeY)){
                        check = true;
                        break;
                    }
                    else {
                        field[i][j] = DOT_EMPTY;
                    }
                    field[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN,WIN_COUNT,fieldSizeX,fieldSizeY)){
                        field[i][j] = DOT_AI;
                        check = true;
                        break;
                    }
                    else{
                        field[i][j] = DOT_EMPTY;
                    }
                }

            }
        }
        if (check == false) {
            do
            {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            }
            while (!isCellEmpty(x, y));
            field[x][y] = DOT_AI;
        
        }
        
    }

    /**
     * Проверка победы
     * @param c
     * @param winCount
     * @param fieldSizeX
     * @param fieldSizeY
     * @return
     */
    static boolean checkWin(char c, int winCount, int fieldSizeX, int fieldSizeY){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (!isCellEmpty(x, y) && field[x][y] == c){
                    if (x + winCount <= fieldSizeX){
                        for (int i = 1; i <= winCount; i++){
                            if (i == winCount){
                                return true;
                            }
                            else if (field[x + i][y] == c){
                                continue;
                            }
                            else{
                                break;
                            }
    
                        }
                    }
                    if (y + winCount <= fieldSizeY){
                        for (int i = 1; i <= winCount; i++){
                            if (i == winCount){
                                return true;
                            }
                            else if (field[x][y + i] == c){
                                continue;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if ((x + winCount <= fieldSizeX) && (y + winCount <= fieldSizeY)){
                        for (int i = 1; i <= winCount; i++){
                            if (i == winCount){
                                return true;
                            }
                            else if (field[x + i][y + i] == c){
                                continue;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if ((x + winCount <= fieldSizeX) && (y - winCount + 1 >= 0)){
                        for (int i = 1; i <= winCount; i++){
                            if (i == winCount){
                                return true;
                            }
                            else if (field[x + i][y - i] == c){
                                continue;
                            }
                            else{
                                break;
                            }
                        }
                    
                    }
                }
                
            }
        }

        return false;
    }

    /**
     * Проверка на ничью
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     * @param c
     * @param str
     * @return
     */
    static boolean gameCheck(char c, String str){
        if (checkWin(c,WIN_COUNT,fieldSizeX,fieldSizeY)){
            System.out.println(str);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

}


public class HeapSort {

    public void Sort(int array[])
    {
        int arrayLength = array.length;

        // Построение кучи (перегруппируем массив)
        for (int i = arrayLength / 2 - 1; i >= 0; i--)
            heap(array, arrayLength, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=arrayLength-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heap(array, i, 0);
        }
    }

     void heap(int array[], int arrayLength, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

           // Если левый дочерний элемент больше корня
        if (l < arrayLength && array[l] > array[largest])
            largest = l;

          // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < arrayLength && array[r] > array[largest])
            largest = r;
       // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heap(array, arrayLength, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int array[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int array[] = {45, 1, 0, 56, 23, 13, 102, 9, 5};
        printArray(array); //вывод первоначального массива
        HeapSort heapSort = new HeapSort();
        heapSort.Sort(array); // вывод отсортированного массива
        printArray(array);
    }
}
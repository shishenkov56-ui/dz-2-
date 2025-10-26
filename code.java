#include <iostream>
using namespace std;
void bubbleSort(int arr[], int n) {
    for (int i=0;i<n-1;i++) {
        bool swapped = false;
        for (int j=0;j<n-i-1;j++) {
            if (arr[j] > arr[j+1]) {
                swap(arr[j], arr[j+1]);
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}
int main() {
    int arr[] = {64,34,25,12,22,11,90};
    int n = sizeof(arr)/sizeof(arr[0]);
    bubbleSort(arr,n);
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
    cout<<endl;
} 

#include <iostream>
#include <vector>
using namespace std;

// Функция сортировки Шелла
void shellSort(vector<int>& arr) {
    int n = arr.size();

    // Начинаем с большого промежутка и уменьшаем его
    for (int gap = n / 2; gap > 0; gap /= 2) {
        // Проходим по элементам с текущим шагом
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;

            // Сдвигаем элементы, которые больше temp, вправо
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }

            // Вставляем temp на найденное место
            arr[j] = temp;
        }
    }
}

// Функция вывода массива
void printArray(const vector<int>& arr) {
    for (int num : arr)
        cout << num << " ";
    cout << endl;
}

// Основная функция
int main() {
    vector<int> arr = {12, 34, 54, 2, 3};

    cout << "Исходный массив: ";
    printArray(arr);

    shellSort(arr);

    cout << "Отсортированный массив: ";
    printArray(arr);

    return 0;
} 

#include <iostream>
#include <vector>

int linearSearch(const std::vector<int>& arr, int target) {
    for (size_t i = 0; i < arr.size(); ++i) {
        if (arr[i] == target) return static_cast<int>(i);
    }
    return -1;
}

int main() {
    std::vector<int> a = {3, 5, 2, 7, 9, 1, 4};
    int target = 7;

    std::cout << "Массив: ";
    for (int v : a) std::cout << v << " ";
    std::cout << "\nИщем: " << target << std::endl;

    int result = linearSearch(a, target);
    if (result != -1)
        std::cout << "Элемент найден на индексе: " << result << std::endl;
    else
        std::cout << "Элемент не найден" << std::endl;

    return 0;
} 

#include <iostream>
using namespace std;
int binarySearch(int arr[], int n, int target) {
    int lo = 0, hi = n-1;
    while (lo <= hi) {
        int mid = lo + (hi-lo)/2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) lo = mid+1;
        else hi = mid-1;
    }
    return -1;
}
int main() {
    int arr[] = {1,3,5,7,9,11};
    cout<<binarySearch(arr, 6, 7)<<endl;
}
 
#include <iostream>
#include <vector>
using namespace std;
int fibonacciSearch(const vector<int>& arr, int x) {
    int n = arr.size();
    int fibMMm2 = 0;
    int fibMMm1 = 1;
    int fibM = fibMMm2 + fibMMm1;
    while (fibM < n) {
        fibMMm2 = fibMMm1;
        fibMMm1 = fibM;
        fibM = fibMMm2 + fibMMm1;
    }
    int offset = -1;
    while (fibM > 1) {
        int i = min(offset + fibMMm2, n-1);
        if (arr[i] < x) {ef selection_sort(arr):
    for i in range(len(arr)):
        min_index = i
        for j in range(i+1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]

if __name__ == '__main__':
    a = [64,25,12,22,11]
    print('Исходный:', a)
    selection_sort(a)
    print('Отсортированный:', a)
            fibM = fibMMm1;
            fibMMm1 = fibMMm2;
            fibMMm2 = fibM - fibMMm1;
            offset = i;
        } else if (arr[i] > x) {
            fibM = fibMMm2;
            fibMMm1 = fibMMm1 - fibMMm2;
            fibMMm2 = fibM - fibMMm1;
        } else return i;
    }
    if (fibMMm1 && offset + 1 < n && arr[offset+1] == x) return offset+1;
    return -1;
}
int main() {
    vector<int> a = {10,22,35,40,45,50,80,82,85,90,100};
    cout<<fibonacciSearch(a,85)<<endl;
} 

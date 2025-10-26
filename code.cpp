def selection_sort(arr):
    for i in range(len(arr)):
        min_index = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]


def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]          # элемент, который нужно вставить
        j = i - 1
        # сдвигаем элементы, которые больше key, вправо
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

def print_array(arr):
    for v in arr:
        print(v, end=" ")
    print()

# Пример использования
a = [12, 11, 13, 5, 6]
print("Исходный:", end=" ")
print_array(a)
insertion_sort(a)
print("Отсортированный:", end=" ")
print_array(a)
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr)//2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(left, right):
    res = []
    i=j=0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            res.append(left[i]); i+=1
        else:
            res.append(right[j]); j+=1
    res.extend(left[i:]); res.extend(right[j:])
    return res

if __name__ == '__main__':
    a = [38,27,43,3,9,82,10]
    print(merge_sort(a))

def partition(arr, low, high):
    pivot = arr[high]   # опорный элемент
    i = low - 1         # индекс меньшего элемента
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]  # обмен
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

def quick_sort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        quick_sort(arr, low, pi - 1)   # сортировка левой части
        quick_sort(arr, pi + 1, high)  # сортировка правой части

# Пример использования
a = [10, 7, 8, 9, 1, 5]
quick_sort(a, 0, len(a) - 1)
print("Отсортированный массив:", a)
 
def heapify(arr, n, i):
    largest = i
    l = 2*i + 1
    r = 2*i + 2
    if l < n and arr[l] > arr[largest]:
        largest = l
    if r < n and arr[r] > arr[largest]:
        largest = r
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heap_sort(arr):
    n = len(arr)
    for i in range(n//2 - 1, -1, -1):
        heapify(arr, n, i)
    for i in range(n-1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

if __name__ == '__main__':
    a = [12,11,13,5,6,7]
    heap_sort(a)
    print(a)

def interpolation_search(arr, lo, hi, x):
    if lo <= hi and x >= arr[lo] and x <= arr[hi]:
        pos = lo + ((hi-lo)*(x - arr[lo])) // (arr[hi] - arr[lo])
        if arr[pos] == x: return pos
        if arr[pos] < x: return interpolation_search(arr, pos+1, hi, x)
        if arr[pos] > x: return interpolation_search(arr, lo, pos-1, x)
    return -1

if __name__ == '__main__':
    a = [10,20,30,40,50,60,70]
    print(interpolation_search(a, 0, len(a)-1, 40))

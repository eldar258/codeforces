Дан массив $a$. Поступают запросы поиска XOR (побитового исключающего или) на отрезке. Вам необходимо на них отвечать.

### Входные данные
Первая строка входных данных содержит одно целое число $n(1 \le n \le 10^6)$ — количество элементов массива.

Вторая строка входных данных содержит $n$ целых чисел $a_i(0 \le a_i \le 10^9)$ — элементы массива $a$.

Третья строка входных данных содержит одно целое число $q(1 \le q \le 10^6)$ — количество запросов поиска XOR'а на отрезке.

Каждая из последующих $q$ строк содержит по два целых числа $l_i$ и $r_i(1 \le l_i \le r_i \le n)$ — границы отрезка массива, на котором нужно найти XOR.

### Выходные данные
Для каждого запроса в отдельной строке выведите XOR элементов на соответствующем отрезке массива (включая границы).
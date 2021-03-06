<h1 align="center">Учебный курс Java Web Development, EPAM<br>

# Tasks
+ [Task 1. Basics (task01basic)](#task1)
+	[Task 2. Arrays. Decomposition (task02array)](#task2)
+	[Task 3. Классы. UML (task03polymorphism, task03innerclass)](#task3)
+	[Task 4. ООП. Репозиторий, спецификация, компаратор (task04repository)](#task4)
+	[Task 5. Многопоточность(task05thread)](#task5)
+	[Task 6. Information handling(task06infohandling)](#task6)
+	[Task 7. XML\XSD & Web-Parsing(task07xmlparser)](#task7)

<a name="task1"></a>
# Task 1. Basics (task01basic)
Линейный программы. Ветвления. Циклы
+ Составить алгоритм нахождения среднего арифметического двух чисел
+ Дан прямоугольник, ширина которого в два раза меньше длины. Найти площадь прямоугольникаагогов и администраторов танцевальной студии. Позволяет просматривать всю необходимую информацию о занятиях, группах и педагогах, подбирать занятия по определенным критериям, записываться на занятия, покупать абонементы, отмечать присутствие на занятиях, просматривать статистику посещений, а также информацию по приобретенным абонементам и др.
+ Дана сторона равностороннего треугольника. Найти площадь этого треугольника, его высоту, радиусы вписанной
и описанной окружностей.
+ Составить программу для вычисления пути, пройденного лодкой, если ее скорость в стоячей воде v км/ч, скорость
течения реки v1 км/ч, время движения по озеру t1 ч, а против течения реки — t2 ч.
+ Ввести любой символ и определить его порядковый номер, а также указать предыдущий и последующий символы.

+ Составить программу: определения наименьшего из двух чисел а и b.
+ Составить программу нахождения модуля выражения a*x*x + b*x + c при заданных значениях a, b, c и х
+ Подсчитать количество положительных среди чисел а, b, с.
+ Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
отверстие.
+ Написать программу, которая по паролю будет определять уровень доступа сотрудника к секретной информации в
базе данных. Доступ к базе имеют только шесть человек, разбитых на три группы по степени доступа. Они имеют
следующие пароли: 9583, 1747 — доступны модули баз А, В, С; 3331, 7922 — доступны модули баз В, С; 9455, 8997 —
доступен модуль базы С.

+ С помощью оператора while напишите программу определения суммы всех нечетных чисел в
диапазоне от 1 до 99 включительно.
+ Вычислить значения функции на отрезке [а,b] c шагом h:h: y = x, if x > 2 and y = -x, if x <= 2\n"
+ Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или
равен заданному е. Общий член ряда имеет вид:where a = 1/2^n + 1/3^n
+ Компьютер генерирует пять чисел в диапазоне от 1 до 15 включительно. Человек пытается их
угадать. Программа должна выводить угаданные и неугаданные числа из тех, что сгенерировала
программа, а также ошибочные числа пользователя.
+ Найдите наибольшую цифру данного натурального числа.
<a name="task2"></a>
# Task 2. Arrays. Decomposition (task02array)
Необходимо написать объектно-ориентированное приложение для работы с одномерными и двумерными массивами:
1.	Определить класс Массив. Создать методы сортировки: 
+ обменная сортировка (метод пузырька); 
+ обменная сортировка «Шейкер-сортировка», 
+ сортировка посредством выбора (метод простого выбора),
+ сортировка вставками: 0 (сортировка с вычислением адреса),
+ сортировка вставками (метод простых вставок), 
+ сортировка бинарного слияния, 
+ сортировка Шелла (сортировка с убывающим шагом).
+ *внешняя сортировка (сортировка файла БОЛЬШОГО размера).
2.	Определить класс Матрица для решения задач сложения, вычитания, умножения, и других операция с матрицами
<a name="task3"></a>
# Task 3. Классы. UML (task03polymorphism, task03innerclass)
Разработать два мультиязычных приложения:
+ Задача: Фургон кофе. Загрузить фургон определенного объема грузом на определенную сумму из различных сортов кофе, находящихся к тому же в разных
физических состояниях (зерно, молотый, растворимый в банках и пакетиках).
Учитывать объем кофе вместе с упаковкой. Провести сортировку товаров на основе соотношения цены и веса. 
Найти в фургоне товар, соответствующий заданному диапазону параметров качества.
+ Задача: Создать класс Shop с внутренним классом, с помощью объектов которого 
можно хранить информацию об отделах, товарах и услугах.
<a name="task4"></a>
# Task 4. ООП. Репозиторий, спецификация, компаратор (task04repository)
+ Разработать классы Точка и Овал (задан двумя точками описанного прямоугольника). Создать методы и тесты: вычисления площади и периметра фигуры; составляют ли точки овал(не лежат ли две точки на одной прямой, параллельной осям координат); пересекает ли фигура только одну из осей координат на заданное расстояние; является ли фигура овалом, кругом.
+ Для корректных данных (фигур) в момент добавления в коллекцию добавить поле ID.
+ Разработать спецификации по поиску объектов и групп объектов в репозитории. По ID, по имени, по координатам (например: найти все объекты точки которых находятся в первом квадранте, найти все объекты площади поверхности (объемы, периметры) которых заключены в заданный диапазон, найти объекты находящиеся на расстоянии в заданном диапазоне от начала координат). Использовать шаблон Specification.
+ Разработать методы сортировки наборов объектов по ID, по имени, по координатам Х первой точки, по координатам Y первой точки и т д. Использовать интерфейс Comparator. Использовать шаблон Specification.
+ Периметры, Площади, Объемы фигур должны храниться в объекте класса-регистратора для каждой фигуры по ее ID. 
+ Любое изменение параметра фигуры должно вызывать пересчет соответствующих значений в классе-регистраторе. 
+ Для решения данной задачи использовать паттерны Observer
<a name="task5"></a>
# Task 5. Многопоточность(task05thread)
Модифицировать приложение Task 2 (Array, Matrix, Decomposition) для поддержки многопоточности.
+ Имитируем работу пользователей, когда для каждого пользователя в отдельном потоке запускается на выполнение выбранныя им команда для работы с массивом или матрицей. 
+ Вычисления тоже должны проводиться в многопоточном режимы.
+ Истользовать порядка 5 вариантов работы с потоками.  
<a name="task6"></a>
# Task 6. Information handling(task06infohandling)
+ Cоздать приложение, разбирающее текст из файла и позволяющее выполнять с текстом три различных операции: 
1. Отсортировать абзацы по количеству предложений.
2.	В каждом предложении отсортировать слова по длине.
3.	Отсортировать лексемы в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
+ Разобранный текст необходимо восстановить в первоначальном виде. Для организации структуры данных использовать Composite.
+ Код, выполняющий разбиение текста на составляющие части, следует оформить в виде классов-парсеров с использованием Chain of Responsibility.
+ Битовые выражения, встречающиеся в тексте, должны быть вычислены. Использовать Interpreter с применением функциональных интерфейсов
<a name="task7"></a>
# Task 7. XML\XSD & Web-Parsing(task07xmlparser)
+ Cоздать xml-файл, хранящий информацию об объектах определенной предметной области. 
+ Для валидации полученного xml-файла необходимо разработать соответствующую ему схему xsd. 
+ Файл загружать в веб-приложение через страницу в браузере, на странице осуществлять выбор парсера. 
+ Выполнить парсинг xml-документа с использованием DOM, SAX, StAX парсеров.
+ Результаты парсинга должны быть выведены в браузер в виде таблицы.

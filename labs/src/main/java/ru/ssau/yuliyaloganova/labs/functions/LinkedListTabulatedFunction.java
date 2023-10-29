package ru.ssau.yuliyaloganova.labs.functions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements TabulatedFunction {

    private int count;
    private Node head;

    @Override
    public Iterator<Point> iterator() {
        return null;
    }

    // Вложенный класс Node описывает узел списка
    static class Node {
        public double x,y;
        public Node next;
        public Node prev;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            StringBuilder str1 = new StringBuilder();
            str1.append("(").append(x).append("; ").append(y).append(")");
            return str1.toString();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
               return false;

            return ((o != null) && (o.getClass() == this.getClass())
                    && (x == ((LinkedListTabulatedFunction.Node)o).x)
                    && (y == ((LinkedListTabulatedFunction.Node)o).y));
        }


        @Override
        public int hashCode() {
            int result = 31 * Double.hashCode(x);
            result = 31 * result + Double.hashCode(y);
            return result;
        }
        @Override
        public Object clone() {
            Node clone = new Node(x, y);
            clone.prev = this.prev;
            clone.next = this.next;
            return clone;
        }
    }

    // Метод addNode добавляет новый узел в конец списка
    public void addNode(double x, double y) {
        Node node = new Node(x, y);
        if (head == null) {  // если список пустой, то новый узел становится первым и единственным
            head = node;
            head.next = head;
            head.prev = head;
        } else { // иначе новый узел в конец списка
            Node last = head.prev;
            node.next = head;
            node.prev = last;
            last.next = node;
            head.prev = node;
        }
        count++;
    }

    // Конструктор принимает два массива значений аргумента и функции и заполняет ими список
    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length < 2) {
            throw new IllegalArgumentException("Длина меньше минимальной");
        } else {
            checkLengthIsTheSame(xValues, yValues);
            checkSorted(xValues);
            for (int i = 0; i < xValues.length; ++i) {
                addNode(xValues[i], yValues[i]);
            }
        }
    }

    /* Конструктор принимает объект MathFunction, начальное и конечное значения аргумента и количество точек
     и заполняет список значениями функции на равноотстоящих точках на отрезке [xFrom, xTo] */
    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) { // если начальное значение больше конечного, меняем их местами
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        if (count < 2) {  // если количество точек меньше 2, выбрасываем исключение
            throw new IllegalArgumentException("count < 2");
        }
        double step = (xTo - xFrom) / (count - 1);  // вычисляем расстояние между соседними точками
        for (int i = 0; i < count; i++) { // заполняем список значениями функции на равноотстоящих точках
            double x = xFrom + i * step;
            addNode(x, source.apply(x));
        }
    }

    // Метод getNode возвращает узел списка по его индексу
    private Node getNode(int index) {
        if (index < 0 || index >= count) { // если индекс выходит за границы списка, выбрасываем исключение
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (index < count / 2) {  // если индекс меньше половины размера списка, ищем узел с начала списка
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else { // иначе ищем узел с конца списка
            Node node = head.prev;
            for (int i = count - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    // Метод insert вставляет новый узел в список на нужное место
    public void insert(double x, double y) {
        if (head == null) {
            addNode(x, y);
        } else {
            Node temp = head.next;
            for (int i = 0; temp != head ; temp = temp.next) {
                if(temp.x == x) {
                    temp.y = y;
                    temp = head;
                    ++count;
                }
                else if(x >head.prev.x) {
                    Node newN = new Node(x, y);
                    head.prev.next = newN;
                    head.prev = newN;
                    temp = head;
                    ++count;
                }
                else if (x < temp.x && x > temp.prev.x) {
                    Node newN = new Node(x, y);
                    temp.prev.next = newN;
                    temp.prev = newN;
                    temp = head;
                    ++count;
                }
                else if (x < head.x) {
                    Node newN = new Node(x, y);
                    head.prev.next = newN;
                    head.prev = newN;
                    head = newN;
                    ++count;
                }
            }
        }
    }

    // Метод getCount возвращает количество элементов в списке
    public int getCount() {
        return count;
    }

    // Метод getX возвращает значение аргумента функции по индексу
    @Override
    public double getX(int index) {
        if (index < 0 || index > count - 1) {
            throw new IllegalArgumentException("Индекс не пренадлежит нужному промежутку");
        } else {
            return getNode(index).x;
        }
    }

    // Метод getY возвращает значение функции по индексу
    @Override
    public double getY(int index) {
        if (index < 0 && index > count - 1) {
            throw new IllegalArgumentException("Индекс не прендлежит нужному промежутку");
        } else {
            return getNode(index).y;
        }
    }

    @Override
    // Метод setY изменяет значение функции по индексу
    public void setY(int index, double value) {
        if (index < 0 && index > count - 1) {
            throw new IllegalArgumentException("Индекс не прендлежит нужному промежутку");
        } else {
            getNode(index).y = value;
        }
    }

    // Метод indexOfX возвращает индекс первого узла с заданным значением аргумента или -1, если такого узла нет
    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (getX(i) == x) {
                return i;
            }
        }
        return -1;
    }

    // Метод indexOfY возвращает индекс первого узла с заданным значением функции или -1, если такого узла нет
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (getY(i) == y) {
                return i;
            }
        }
        return -1;
    }

    // Метод leftBound возвращает значение аргумента первого узла списка.
    public double leftBound() {
        return head.x;
    }

    // Метод rightBound возвращает значение аргумента последнего узла списка.
    public double rightBound() {
        return head.prev.x;
    }

    // Метод apply вычисляет значение функции в точке x методом линейной интерполяции между ближайшими узлами.
    public double apply(double x) {
        //Node floorNode = floorNodeOfX(x);
        if (x < head.x) { // Если x меньше значения аргумента первого узла списка, то используется метод extrapolateLeft.
            return extrapolateLeft(x);
        } else if (x > head.prev.x) { // Если x больше значения аргумента последнего узла списка, то используется метод extrapolateRight.
            return extrapolateRight(x);
        } else if (floorNodeOfX(x).x == x) { // Если найден узел списка с аргументом, равным x, то возвращается значение его функции.
            return floorNodeOfX(x).y;
        } else { // В остальных случаях вычисляется значение функции методом interpolate между ближайшими узлами.
            return interpolate(x, floorIndexOfX(x));
        }
    }

    /* Метод interpolate вычисляет значение функции в точке x методом линейной интерполяции между узлами
    с индексами floorNode и floorNode.next, если floorNode не равен null и имеет следующий узел.
    Иначе выбрасывается исключение IllegalArgumentException. */
    public double interpolate(double x, int floorIndex) {
        Node floorNode = floorNodeOfX(x);
        if (floorNode == null || floorNode.next == null) {
            throw new IllegalArgumentException("Node is not valid for interpolation");
        }
        if (floorIndex < 0 || floorIndex >= getCount() - 1) {
            throw new IllegalArgumentException("Index out of range: " + floorIndex);
        }
        double x1 = floorNode.x;
        double y1 = floorNode.y;
        double x2 = floorNode.next.x;
        double y2 = floorNode.next.y;
        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }

    // Метод extrapolateLeft вычисляет значение функции в точке x методом экстраполяции слева на основе первых двух узлов.
    public double extrapolateLeft(double x) {
        if (getCount() < 2) {
            return getY(0);
        }
        double x1 = getX(0);
        double y1 = getY(0);
        double x2 = getX(1);
        double y2 = getY(1);
        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }

    // Метод extrapolateRight вычисляет значение функции в точке x методом экстраполяции справа на основе последних двух узлов.
    public double extrapolateRight(double x) {
        if (getCount() < 2) {
            return getY(0);
        }
        double x1 = getX(getCount() - 2);
        double y1 = getY(getCount() - 2);
        double x2 = getX(getCount() - 1);
        double y2 = getY(getCount() - 1);
        return y2 + (y2 - y1) * (x - x2) / (x2 - x1);
    }

    // Метод floorIndexOfX возвращает индекс узла списка с максимальным значением аргумента, которое не превышает x.
    public int floorIndexOfX(double x) {
        if (x < leftBound()) {
            throw new IllegalArgumentException("x is less than the left bound");
        }
        if (x > rightBound()) {
            return getCount() - 2;
        }
        int i = 0;
        while (getX(i) < x) {
            i++;
            if (i == getCount()) {
                return getCount() - 1;
            }
        }
        return i - 1;
    }

    // Метод floorNodeOfX ищет узел списка с аргументом, меньшим или равным заданному значению x.
    // prevNode - предыдущий узел списка.
    // currentNode - текущий узел списка.
    protected Node floorNodeOfX(double x) {
        if (x < leftBound()) {
            throw new IllegalArgumentException("Значение x меньше левой границы");
        }

        Node prevNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.x <= x) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            } else {
                return (prevNode != null) ? prevNode : new Node(x, 0);
            }
        }
        return new Node(x, count); // если список пуст, возвращаем новый узел с функцией, равной количеству узлов в списке
    }

    // Метод remove удаляет узел списка с заданным индексом.
    public void remove(int index) {
        if (count == 1) { // Если список содержит только один узел, он удаляется полностью.
            head = null;
        } else {
            Node node = getNode(index); // Получаем узел с заданным индексом.
            node.prev.next = node.next; // Смещаем соседние узлы
            node.next.prev = node.prev;
            if (node == head) { // Если это был первый узел, то следующий теперь головной
                head = node.next;
            }
        }
        count--; // Уменьшаем кол-во элементов
    }
    @Override
    public String toString() {
        StringBuilder str1 = new StringBuilder(); // создаем объект StringBuilder для построения строки
        Node current = head;
        for (int i = 0; i < count; i++) {
            String node = current.toString();
            str1.append(node).append(", ");
            current = current.next;
        }
        str1.delete(str1.length() - 2, str1.length()); // удаляем последнюю запятую и пробел
        return str1.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Node node = head;  // Получаем первый узел списка
        if (o.getClass() == o.getClass() && count == ((LinkedListTabulatedFunction)o).getCount()) {
            Node othernode = ((LinkedListTabulatedFunction)o).getNode(0); // Получаем первый узел другого списка
            // Сравниваем каждый узел текущего списка с соответствующим узлом другого списка
            do {
                if (!node.equals(othernode)) return false;
                node = node.next;
                othernode = othernode.next;
            } while (node != head);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0; // инициализируем переменную результатом
        for (Node temp = head; temp != head.prev; temp = temp.next) {

            result = result * 31 + temp.hashCode();
        }
        result = result * 31 + head.prev.hashCode(); // вычисляем хеш-код для последнего узла и добавляем его к результату
        return result;
    }
    @Override
    public Object clone() {
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        int i = 0;
        for (Node temp = head; temp != head.prev; temp = temp.next) {
            xValues[i] = temp.x;
            yValues[i] = temp.y;
            i++;
        }
        xValues[count - 1] = head.prev.x; // добавляем координату x последнего узла в массив
        yValues[count - 1] = head.prev.y; // добавляем координату y последнего узла в массив
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
}
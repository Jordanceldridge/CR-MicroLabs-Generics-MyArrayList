import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList <T> {
    private T[] inputArray;

    //Constructor
    public MyArrayList(){
        this.inputArray = (T[]) new Object[0];
    }
    public MyArrayList(int size){
        this.inputArray = (T[]) new Object[size];
    }
    //This is where my methods go
    public void add(T element){
        T[] array1 = Arrays.copyOf(inputArray,inputArray.length + 1);
        array1[array1.length-1]= element;
        this.inputArray = array1;
    }
    public void addAnyWhere(T value,int index){
        T[] array2 = Arrays.copyOf(inputArray,inputArray.length +1);

        if (array2[index].equals(null)){
            array2[index]=value;
        } else {
            Integer count = inputArray.length;

            while (index < count){
                array2[count] = array2[count- 1];
                count--;
            }
            array2[index] = value;
        }
        inputArray = array2;
    }
    public Integer size(){
        return this.inputArray.length;
    }
    public T get(int index){
        return this.inputArray[index];
    }
    public void set(int index, T element){
        inputArray[index] = element;
    }
    public void clear(){
        inputArray = Arrays.copyOf(inputArray,0);
    }
    public Integer indexOf(T element){
        for (int i =0; i <inputArray.length; i++){
            if (element.equals(inputArray[i])){

            }
            return i;


        }
        return null;



    }
    public boolean contains (T element){
        for (int i =0; i <inputArray.length;i++){
            if (element.equals(inputArray[i])){
                return true;
            }
        }
        return false;
    }
    public void remove(T element){
        if (!contains(element)){
            T[] identicalArray = Arrays.copyOf(inputArray,inputArray.length);
            inputArray = identicalArray;
        }else {
            T[] reducedArray = Arrays.copyOf(inputArray,inputArray.length -1);
            int indexToRemove = indexOf(element);
            for (int i = indexToRemove; i <inputArray.length -1;i++){
                reducedArray[i] = inputArray[i + 1];
            }
            inputArray = reducedArray;
        }
    }
    public T[] toArray(T[] newArray){
        return (T[]) Arrays.copyOf(inputArray,inputArray.length,newArray.getClass());

    }
    public T[] toArray(){
        T[] temp = (T[]) new Object[size()];
        for (int i =0; i <size(); i++){
            temp[i] = get(i);
        }
        return inputArray = temp;
    }
    public boolean isEmpty(){
        if (inputArray.length ==0){
            return true;
        }
        return false;
    }

    public void printArrayContents() {
        String arrayAsString = Arrays.toString(inputArray);
        System.out.println(arrayAsString);
    }
}
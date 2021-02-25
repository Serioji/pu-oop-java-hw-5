package Pixel;

class Custom<T>{

    private int placeholderPointer=0;
    private final Object[] collection;

    public Custom(){
        this.collection = new Object[5];
    }
    public void add(String str){
        this.collection[placeholderPointer++] = str;
    }
    public void display(){
        for (Object i : collection) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
}
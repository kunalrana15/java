
class Dog{
    String name;
    String breed;
    int age;
    String color;

    public Dog(String name,String breed,int age,String color){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public int getAge(){
        return age;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        return "Name is:" + name + "\nBreed age and color are:" + breed + " " + age + " " + color;
    }
}

public class ClassesAndObjects {
    public static void main(String[] args){
        Dog dog = new Dog("Tuffy","papillon",5,"White");
        System.out.println(dog.getName());
        System.out.println(dog.toString());
    }
}

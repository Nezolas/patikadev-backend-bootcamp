public abstract class Worker {
    private String name;
    private int age;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public Worker(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void show() {
        System.out.println(name + " " + age + " " + id);
    }
}
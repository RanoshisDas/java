class Hello
{
    int p;
    Hello()
    {
        p=14;
    }
    void display()
    {
        System.out.print(p);
    }
}
class Main
{
    public static void main(String arg[])
    {
        Hello rano =new Hello();
        rano.display();
    }
}